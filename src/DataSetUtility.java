import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
public class DataSetUtility {
    private static ArrayList<DataSet> mariooo;

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
    public static int bestCountryPlacement(String country) {
        int best = 1000;
        for (int i = 0; i < mariooo.size(); i++) {
            if(mariooo.get(i).getCountry().equals(country)) {
                if (mariooo.get(i).getPlacement() < best) {
                    best = mariooo.get(i).getPlacement();
                }
            }
        }
        return best;
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
    public String bestCountry() {
        ArrayList<Integer> times = new ArrayList<>();
        ArrayList<String> countries = new ArrayList<>();
        String minCountry = "";
        int min = Integer.MAX_VALUE;
        boolean oui = true;
        for (int i = 0; i < mariooo.size(); i++) {
            for (int j = 0; j < countries.size(); j++) {
                if (countries.get(j).equals(mariooo.get(i).getCountry())) {
                    oui = false;
                }
            }
            if (oui) {
                countries.add(mariooo.get(i).getCountry());
                int temper = DataSetUtility.bestCountryPlacement(mariooo.get(i).getCountry());
                times.add(temper);
            }
            else {
                int temper = DataSetUtility.bestCountryPlacement(mariooo.get(i).getCountry());
                times.set(i ,times.get(i) + temper);
            }
            oui = true;
        }
        for(int k = 0; k < times.size(); k++) {
            if(times.get(k) < min) {
                min = times.get(k);
                minCountry = countries.get(k);
            }
        }
        return minCountry;
    }
}
