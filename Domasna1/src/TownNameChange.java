public class TownNameChange implements FilterData<String> {
    @Override
    public String execute(String input) {
        String [] parts=input.split(",");
        String tmp=parts[5];
        tmp=tmp.toLowerCase();
        tmp=Character.toUpperCase(tmp.charAt(0)) + tmp.substring(1);
        parts[5]=tmp;
        String res="";
        for(int i=0;i<parts.length;i++){
            res+=parts[i] + ",";
        }
        return res;
    }
}
