import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Domasna {
    public static void printToFile(PrintWriter printWriter,String town,List<String> townData){
        printWriter.format("%s: \n\n\n",town);
        for (String line : townData) {
            String[] parts = line.split(",");
            printWriter.format("Name: %s\n", parts[0]);
            printWriter.format("Number1: %s\n", parts[1]);
            printWriter.format("Number2: %s\n", parts[2]);
            printWriter.format("Number3: %s\n", parts[3]);
            printWriter.format("Address: %s\n", parts[4]);
            printWriter.format("Town: %s\n", parts[5]);
            printWriter.format("Email: %s\n", parts[6]);
            printWriter.format("Web page: %s\n", parts[7]);
            printWriter.format("Link: %s\n", parts[8]);
            printWriter.format("Catalog: %s\n", parts[9]);
            printWriter.format("Facebook: %s\n", parts[10]);
            printWriter.format("Instagram: %s\n", parts[11]);
            printWriter.format("Picture: %s\n", parts[12]);
            printWriter.format("Rating: %s\n\n\n", parts[13]);
        }
    }
    public static void main(String[] args) throws IOException {

        String Fileread = "src/updated_winery_data-1.txt";
        Scanner reader = new Scanner(new File(Fileread));
        String line1;
        NameChangeFilter nameChangeFilter = new NameChangeFilter();
        TownNameChange townNameChange = new TownNameChange();
        NoneFilter noneFilter = new NoneFilter();
        ChangeNumber changeNumberFilter = new ChangeNumber();
        PipeAndFilter<String> pipeAndFilter = new PipeAndFilter<>();
        pipeAndFilter.addFilter(nameChangeFilter);
        pipeAndFilter.addFilter(townNameChange);
        pipeAndFilter.addFilter(noneFilter);
        pipeAndFilter.addFilter(changeNumberFilter);
        List<String> Skopje = new ArrayList<>();
        List<String> Demir_Kapija = new ArrayList<>();
        List<String> Veles = new ArrayList<>();
        List<String> Kavadarci = new ArrayList<>();
        List<String> Negotino = new ArrayList<>();
        List<String> Stip = new ArrayList<>();
        List<String> Ohrid = new ArrayList<>();
        List<String> Radovis = new ArrayList<>();
        List<String> Gevgelija = new ArrayList<>();
        List<String> Bogdanci = new ArrayList<>();
        List<String> Struga = new ArrayList<>();
        List<String> Vinica = new ArrayList<>();
        List<String> Prilep = new ArrayList<>();
        List<String> Valandovo = new ArrayList<>();
        List<String> Kumanovo = new ArrayList<>();
        while (reader.hasNextLine()) {
            line1 = reader.nextLine();
            String line2 = pipeAndFilter.runFilters(line1);
            String[] parts = line2.split(",");
            switch (parts[5]) {
                case "Veles":
                    Veles.add(line2);
                    break;

                case "Kavadarci":
                    Kavadarci.add(line2);
                    break;

                case "Skopje":
                    Skopje.add(line2);
                    break;

                case "Demir kapija":
                    Demir_Kapija.add(line2);
                    break;

                case "Negotino":
                    Negotino.add(line2);
                    break;

                case "Stip":
                    Stip.add(line2);
                    break;

                case "Ohrid":
                    Ohrid.add(line2);
                    break;

                case "Radovis":
                    Radovis.add(line2);
                    break;

                case "Gevgelija":
                    Gevgelija.add(line2);
                    break;

                case "Bogdanci":
                    Bogdanci.add(line2);
                    break;

                case "Struga":
                    Struga.add(line2);
                    break;

                case "Vinica":
                    Vinica.add(line2);
                    break;

                case "Prilep":
                    Prilep.add(line2);
                    break;

                case "Valandovo":
                    Valandovo.add(line2);
                    break;

                case "Kumanovo":
                    Kumanovo.add(line2);
                    break;
            }
        }
        String printPath = "src\\result.csv";
        PrintWriter printWriter = new PrintWriter(new FileWriter(printPath));
        List<List<String>> townDataLists = Arrays.asList(Veles, Kavadarci, Skopje, Negotino, Stip, Struga, Ohrid, Gevgelija, Bogdanci,
                Radovis, Demir_Kapija, Vinica, Prilep, Valandovo, Kumanovo);
        for (List<String> townData : townDataLists) {
            if (!townData.isEmpty()) {
                String line = townData.get(0);
                String[] parts = line.split(",");
                printToFile(printWriter, parts[5], townData);
            }
        }
        printWriter.close();
    }
}