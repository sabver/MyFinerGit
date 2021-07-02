package finergit.ast;

import java.nio.file.Path;
import finergit.FinerGitConfig;

public class FinerJavaClass extends FinerJavaModule {

  private static final String CLASS_EXTENSION = ".cjava";
  private static final String CLASS_DELIMITER = "$";
  
  private String packageName;

  public FinerJavaClass(final String name, final String packageName, final FinerJavaModule outerModule,
      final FinerGitConfig config) {
    super(name, outerModule, config);
    this.packageName = packageName;
  }

  @Override
  public Path getDirectory() {
    return this.outerModule.getDirectory();
  }

  @Override
  public String getExtension() {
    return CLASS_EXTENSION;
  }

  /**
   * ベースネーム（拡張子がないファイル名）を返す．
   *
   * @return
   */
  @Override
  public String getBaseName() {

    final StringBuilder builder = new StringBuilder();

    // 外側のモジュールがファイル名の場合は，
    // ファイル名とこのクラス名が違う場合のみ，
    // ファイル名を含める
    if (FinerJavaFile.class == this.outerModule.getClass()) {
      if (!this.name.equals(this.outerModule.name)) {
        builder.append("[")
            .append(this.outerModule.name)
            .append("]");
      }
    }

    // 内部クラスの場合は外側のクラス名を含める
    else if (FinerJavaClass.class == this.outerModule.getClass()) {
      builder.append(this.outerModule.getBaseName())
          .append(CLASS_DELIMITER);
    }
    
    if( null != packageName && "".equals(packageName) == false ) {
    	builder.append(packageName);
    	builder.append(".");
    }
    builder.append(this.name);
    return builder.toString();
  }
}
