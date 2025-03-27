package com.emp.model;

public class JavaToHTML {
    // Private constructor to hide the implicit public one
    private JavaToHTML() {}

    private static final String table = "table";
    private static final String select = "select";
    public static String markIO(Object obj, String outtype, String forms) {
        StringBuilder outString = new StringBuilder();
        forms=forms.toLowerCase();
        for (Object subobj : obj.getInstance()) {
            if (subobj.getInstance() != null) {
                markIO(obj, outtype, forms);
            } else {
                processSubObject(subobj, outtype, forms, outString);
            }
        }
        if(forms.equals(table) || forms.equals(select)) {
            outString="<${forms}>"+outString.toString()+"</${forms}>";
        }
        return outString.toString();
    }

    private static void processSubObject(Object subobj, String outtype, String forms, StringBuilder outString) {
        switch (outtype) {
            case "html":
                processHtml(subobj, forms, outString);
                break;
            case "json":
                // not ready yet
                break;
            case "xml":
                // not ready yet
                break;
            case "markdown":
                // not ready yet
                break;
            case "latex":
                // not ready yet
                break;
            default:
                System.out.println("Language: Not defined.");
                break;
        }
    }
    private static void processHtml(Object subobj, String forms, StringBuilder outString) {
        if (forms.equals(table) || forms.equals(select)) {
            if (forms.equals(table)) {
                outString.append("<tr><td>").append(subobj).append("</td>");
            } else if (forms.equals(select) || forms.equals("option")) {
                outString.append("<option>").append(subobj).append("</option>");
            }
        } else if (forms.equals("textarea") || forms.equals("radio") || forms.equals("checkbox") ||
                forms.equals("search") || forms.equals("date") || forms.equals("number") ||
                forms.equals("text")) {
            outString.append("<input type=\"").append(forms).append("\" name=\"").append(subobj.getname())
                    .append("\" value=\"").append(subobj.getvalue()).append("\">");
        } else {
            System.out.println("HTML: Invalid form type.");
        }
    }
}
