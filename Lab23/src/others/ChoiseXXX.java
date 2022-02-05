package others;
import java.io.File;
import java.io.FilenameFilter;

//Класс, используемый для выбора списка файлов
public class ChoiseXXX {
	public String  listxxx[];
	protected class OnlyXXX implements FilenameFilter {
		String xxx = null;
		public OnlyXXX(String xxx) {
			this.xxx = "." + xxx;
		}
		public boolean accept(File d, String name) {
			return name.endsWith(xxx);
		}
	}
	public ChoiseXXX(String d, String xxx) {
		File dir = new File(d);
		if (dir.exists()) {
			listxxx = dir.list(new OnlyXXX(xxx));
		}
	}
}
