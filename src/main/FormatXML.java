package main;

public class FormatXML {
	public static void asXML(StringBuffer sb) {
        String[] splitByBrackets = sb.toString().split(">"); // 以結束標籤的符號">"切開所有標籤
         
        int stackCount = 0; // 階層計算, 用以記錄目前要塞幾個"\t"
        boolean lastIsEndTag = false; // 記錄上一筆是否為結尾標籤
         
        sb.replace(0, sb.length(), "");
         
        for (String s : splitByBrackets) {
            String title = "";
            String tabBeforeTarget = "";
          
                 
            if (s.endsWith("/")) { // 單標籤, 直接結束換行 不調整階層
                lastIsEndTag = true;
                title = "\n";
                tabBeforeTarget = getTab(stackCount);
 
            } else if (0 == stackCount) { // 無階層, 表示為第一層標籤
                stackCount++;
                title = "\n";
 
            } else if (0 <= s.indexOf("</")) { // 標籤結尾
                stackCount--;
                if (lastIsEndTag) {
                    title = "\n";
                    tabBeforeTarget = getTab(stackCount);
                }
                lastIsEndTag = true;
 
            } else { // 標籤開頭,
                lastIsEndTag = false;
                title = "\n";
                tabBeforeTarget = getTab(stackCount++);
            }
             
            sb.append(title + tabBeforeTarget + s + ">");
        }
       sb.append("\n");
    }
	public static String getTab(int count) {
        String tab = "";
        for (int i = 1; i <= count; i++) {
            tab += "     "; // 塞階層
        }
        return tab;
    }

}
