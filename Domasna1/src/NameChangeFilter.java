public class NameChangeFilter implements FilterData<String> {
    @Override
    public String execute(String input) {
        String [] parts=input.split(",");
        String tmp=parts[0];
        tmp=tmp.toLowerCase();
        tmp=Character.toUpperCase(tmp.charAt(0)) + tmp.substring(1);
        String res=tmp + ",";
        for(int i=1;i<parts.length;i++){
            res+=parts[i] + ",";
        }
        return res;
    }
}
