package finergit;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import finergit.util.Timer;

public class AnotherFinerGitMain {
	
	private static final Logger log = LoggerFactory.getLogger(AnotherFinerGitMain.class);
	
	/**
	 * ye marked another entrance for FinerGit
	 * 
	 * @param srcPath
	 * @param desPath
	 */
	public void main(String srcPath, String desPath) {
		String[] args = { "--src", srcPath, "--des", desPath };
		final ch.qos.logback.classic.Logger rootLog = (ch.qos.logback.classic.Logger) LoggerFactory
				.getLogger(Logger.ROOT_LOGGER_NAME);
		rootLog.setLevel(Level.ERROR);

		final FinerGitConfig config = new FinerGitConfig();
		final CmdLineParser cmdLineParser = new CmdLineParser(config);
		try {
			cmdLineParser.parseArgument(args);
		} catch (final CmdLineException e) {
			cmdLineParser.printUsage(System.err);
			return;
		}

		final Timer timer = new Timer();
		timer.start();

		final FinerGitMain finerGitMain = new FinerGitMain(config);
		finerGitMain.exec();

		timer.stop();
		log.info("elapsed time: {}", timer.toString());
	}
}
