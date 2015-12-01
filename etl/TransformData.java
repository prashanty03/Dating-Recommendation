import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class TransformData {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        long lStartTime = System.currentTimeMillis();
        System.out.println(lStartTime);

        Name n = new Name();
        Age a = new Age();
        Gender g = new Gender();
        Ethnicity e = new Ethnicity();
        City c = new City();
        Interest interest = new Interest();
        Profession p = new Profession();
        Intent intent = new Intent();

        BufferedWriter bw=null;
        FileWriter fw = null;
        try {
            BufferedReader brName = n.populateName();
            BufferedReader brAge = a.populateAge();
            BufferedReader brGender = g.populateGender();
            BufferedReader brEthnicity = e.populateEthnicity();
            BufferedReader brCity = c.populateCity();
            BufferedReader brInterest = interest.populateInterest();
            BufferedReader brProfession = p.populateProfession();
            BufferedReader brIntent = intent.populateIntent();
            fw = new FileWriter("G:/CMPE 239 Eirinaki/testing/data.csv",true);
            bw = new BufferedWriter(fw);

            StringBuffer sb = new StringBuffer();

            String sName, sAge, sGender, sEthnicity, sCity, sInterest, sProfession, sIntent;

            List<String> nameList= new ArrayList<String>();
            List<String> ageList= new ArrayList<String>();
            List<String> genderList= new ArrayList<String>();
            List<String> ethnicityList= new ArrayList<String>();
            List<String> cityList= new ArrayList<String>();
            List<String> interestList= new ArrayList<String>();
            List<String> professionList= new ArrayList<String>();
            List<String> intentList= new ArrayList<String>();

            while((sName=brName.readLine())!=null){
                nameList.add(sName);
            }
            while((sAge=brAge.readLine())!=null){
                ageList.add(sAge);
            }
            while((sGender=brGender.readLine())!=null){
                genderList.add(sGender);
            }
            while((sEthnicity=brEthnicity.readLine())!=null){
                ethnicityList.add(sEthnicity);
            }
            while((sCity=brCity.readLine())!=null){
                cityList.add(sCity);
            }
            while((sInterest=brInterest.readLine())!=null){
                interestList.add(sInterest);
            }
            while((sProfession=brProfession.readLine())!=null){
                professionList.add(sProfession);
            }
            while((sIntent=brIntent.readLine())!=null){
                intentList.add(sIntent);
            }

            String name = null;
            String age = null;
            String gender = null;
            String ethnicity, city, interest1, profession, intent1, relation;
            for(int i=0; i<6;i++){
                age = ageList.get(new Random().nextInt(ageList.size()));
                gender = genderList.get(new Random().nextInt(genderList.size()));
                for(int j=0; j<5;j++){
                    name = nameList.get(i);
                    ethnicity = (j==0)?ethnicityList.get(new Random().nextInt(ethnicityList.size())):null;
                    city = (j==1)?cityList.get(new Random().nextInt(cityList.size())):null;
                    interest1 = (j==2)?interestList.get(new Random().nextInt(interestList.size())):null;
                    profession = (j==3)?professionList.get(new Random().nextInt(professionList.size())):null;
                    intent1 = (j==4)?intentList.get(new Random().nextInt(intentList.size())):null;

                    sb.append(name);
                    sb.append(",");
                    sb.append(age);
                    sb.append(",");
                    sb.append(gender);
                    sb.append(",");
                    sb.append(ethnicity);
                    sb.append(",");
                    sb.append(city);
                    sb.append(",");
                    sb.append(interest1);
                    sb.append(",");
                    sb.append(profession);
                    sb.append(",");
                    sb.append(intent1);
                    sb.append("\n");

                    System.out.println(sb);
                }
            }
            bw.write(sb.toString());
            bw.close();

            long lEndTime = System.currentTimeMillis();
            System.out.println(lEndTime);
            long difference = lEndTime - lStartTime;

            System.out.println("Elapsed milliseconds: " + difference);

        } catch(IOException err) {
            err.printStackTrace();
        } finally {

            close(fw);
        }
    }
    public static void close(Closeable stream) {
        try {
            if (stream != null) {
                stream.close();
            }
        } catch(IOException e) {
            //...
        }
    }

}

class Name{
    FileReader fr1 = null;
    BufferedReader br1;

    public Name(){

    }

    public BufferedReader populateName(){
        try{
            //fr1 = new FileReader("G:/CMPE 239 Eirinaki/Project/datasets/project datasets/family.csv");
            fr1 = new FileReader("G:/CMPE 239 Eirinaki/testing/1.csv");
            br1 = new BufferedReader(fr1);
        }
        catch(IOException e1){
            e1.printStackTrace();
        }

        return br1;

    }
}

class Age{
    FileReader fr2 = null;
    BufferedReader br2;

    public Age(){

    }

    public BufferedReader populateAge(){
        try{
            //fr2 = new FileReader("G:/CMPE 239 Eirinaki/Project/datasets/project datasets/age.csv");
            fr2 = new FileReader("G:/CMPE 239 Eirinaki/testing/2.csv");
            br2 = new BufferedReader(fr2);
        }
        catch(IOException e2){
            e2.printStackTrace();
        }

        return br2;

    }
}

class Gender{
    FileReader fr3 = null;
    BufferedReader br3;

    public Gender(){

    }

    public BufferedReader populateGender(){
        try{
            //fr3 = new FileReader("G:/CMPE 239 Eirinaki/Project/datasets/project datasets/gender.csv");
            fr3 = new FileReader("G:/CMPE 239 Eirinaki/testing/3.csv");
            br3 = new BufferedReader(fr3);
        }
        catch(IOException e3){
            e3.printStackTrace();
        }

        return br3;

    }
}

class Ethnicity{
    FileReader fr4 = null;
    BufferedReader br4;

    public Ethnicity(){

    }

    public BufferedReader populateEthnicity(){
        try{
            //fr4 = new FileReader("G:/CMPE 239 Eirinaki/Project/datasets/project datasets/ethnicity.csv");
            fr4 = new FileReader("G:/CMPE 239 Eirinaki/testing/4.csv");
            br4 = new BufferedReader(fr4);
        }
        catch(IOException e4){
            e4.printStackTrace();
        }

        return br4;

    }
}

class City{
    FileReader fr5 = null;
    BufferedReader br5;

    public City(){

    }

    public BufferedReader populateCity(){
        try{
            //fr5 = new FileReader("G:/CMPE 239 Eirinaki/Project/datasets/project datasets/cities.csv");
            fr5 = new FileReader("G:/CMPE 239 Eirinaki/testing/5.csv");
            br5 = new BufferedReader(fr5);
        }
        catch(IOException e5){
            e5.printStackTrace();
        }

        return br5;

    }
}

class Interest{
    FileReader fr6 = null;
    BufferedReader br6;

    public Interest(){

    }

    public BufferedReader populateInterest(){
        try{
            //fr6 = new FileReader("G:/CMPE 239 Eirinaki/Project/datasets/project datasets/interest.csv");
            fr6 = new FileReader("G:/CMPE 239 Eirinaki/testing/6.csv");
            br6 = new BufferedReader(fr6);
        }
        catch(IOException e6){
            e6.printStackTrace();
        }

        return br6;

    }
}

class Profession{
    FileReader fr7 = null;
    BufferedReader br7;

    public Profession(){

    }

    public BufferedReader populateProfession(){
        try{
            //fr7 = new FileReader("G:/CMPE 239 Eirinaki/Project/datasets/project datasets/profession.csv");
            fr7 = new FileReader("G:/CMPE 239 Eirinaki/testing/7.csv");
            br7 = new BufferedReader(fr7);
        }
        catch(IOException e7){
            e7.printStackTrace();
        }

        return br7;

    }
}

class Intent{
    FileReader fr8 = null;
    BufferedReader br8;

    public Intent(){

    }

    public BufferedReader populateIntent(){
        try{
            //fr8 = new FileReader("G:/CMPE 239 Eirinaki/Project/datasets/project datasets/intent.csv");
            fr8 = new FileReader("G:/CMPE 239 Eirinaki/testing/8.csv");
            br8 = new BufferedReader(fr8);
        }
        catch(IOException e8){
            e8.printStackTrace();
        }

        return br8;

    }
}