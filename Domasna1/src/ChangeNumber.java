public class ChangeNumber implements FilterData<String> {
    @Override
    public String execute(String input) {

        String [] parts=input.split(",");
        String tmp=parts[1];
        if(!tmp.equals("None")){
            String formattedNumber = tmp.replaceAll("[^0-9]", "");
            if(formattedNumber.startsWith("07")){
                formattedNumber=formattedNumber.substring(1);
                tmp="+389" + formattedNumber;
            }
            //ako brojot pocnuva so 043 ili 02 prodolzi
        }
        String tmp2=parts[2];
        if(!tmp2.equals("None")){
            String formattedNumber = tmp2.replaceAll("[^0-9]", "");
            if(formattedNumber.startsWith("07")){
                formattedNumber=formattedNumber.substring(1);
                tmp2="+389" + formattedNumber;
            }
            //ako brojot pocnuva so 043 ili 02 prodolzi
        }
        String tmp3=parts[3];
        if(!tmp3.equals("None")){
            String formattedNumber = tmp3.replaceAll("[^0-9]", "");
            if(formattedNumber.startsWith("07")){
                formattedNumber=formattedNumber.substring(1);
                tmp3="+389" + formattedNumber;
            }
            //ako brojot pocnuva so 043 ili 02 prodolzi
        }
        String result = "";
        for(int i=0; i<parts.length; i++){
            if(i==1){
                result += tmp + ",";
            }
            else if(i==2){
                result += tmp2 + ",";
            }
            else if(i==3){
                result += tmp3 + ",";
            }
            else {
                result += parts[i] + ",";
            }

        }
        return result;
    }
}