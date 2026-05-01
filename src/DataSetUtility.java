import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
public class DataSetUtility {
    private ArrayList<DataSet> mariooo;

    public void loadFromFile(String fileName) throws IOException{
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        ArrayList<DataSet> SataDet = new ArrayList<>();
        String[] line = new String[11];
        while (sc.hasNextLine()) {
            line = sc.nextLine().split(",");
            SataDet.add(new DataSet(line[10], Integer.parseInt(line[1]), Integer.parseInt(line[4]), line[7], line[8]));
        }
        mariooo = SataDet;
    }

    public double convertTime(int placement, String convert) {
        int timeage = 0;
        if (convert.equals("minutes")) {
            if (placement == 1)
            {
                return (mariooo.get(0).getTime() / 60);
            }
            else {
                return (mariooo.get(placement - 1).getTime() / 60);
            }
        }
        else if (convert.equals("hours")) {
            if (placement == 1)
            {
                return ((mariooo.get(0).getTime() / 60)/ 60);
            }
            else {
                return ((mariooo.get(placement - 1).getTime() / 60)/ 60);
            }
        }
        else {
            System.out.println("Input valid time change like \"minutes\" or \"hours\"");
            return 0.0;
        }
    }
    public String bestCountryPlacement(String country) {
        int best = 1000;
        String bestCountry = "";
        for (int i = 0; i < mariooo.size(); i++) {
            if(mariooo.get(i).getCountry().equals(country)) {
                if (mariooo.get(i).getPlacement() < best) {
                    best = mariooo.get(i).getPlacement();
                    bestCountry = mariooo.get(i).getCountry();
                }
            }
        }
        return bestCountry;
    }
    public int personalRecord(String name) {
        int best = Integer.MAX_VALUE;
        for (int i = 0; i < mariooo.size(); i++) {
            if(mariooo.get(i).getName().equals(name)) {
                if (mariooo.get(i).getTime() < best) {
                    best = mariooo.get(i).getTime();
                }
            }
        }
        return best;
    }
    public String getNamePlacement(int placement) {
        return mariooo.get(placement - 1).getName();
    }

}
