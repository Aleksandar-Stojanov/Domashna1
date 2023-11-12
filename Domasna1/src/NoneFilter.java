public class NoneFilter implements FilterData<String>{
    @Override
    public String execute(String input) {
        String [] parts=input.split(",");
        for (int i=0;i<parts.length;i++){
            if(parts[i].equals("n")){
                parts[i]="None";
            }
            else
                continue;
        }
        String res="";
        for (int i=0;i<parts.length;i++){
            res+=parts[i] + ",";
        }
        return res;
    }
}
