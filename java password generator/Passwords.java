import java.util.Random;
import java.util.ArrayList;

public class Passwords {
    
    Random random = new Random();

    private int length;
    
    private ArrayList<Character> upperList = new ArrayList<>();
    private ArrayList<Character> lowerList = new ArrayList<>();
    private ArrayList<Character> specialList = new ArrayList<>();
    String passwordStr;

    public Passwords(int length){
        this.length = length;
        generatePasswords(length);
    }

    public String getPassword(){
        return this.passwordStr;
    }

    public ArrayList<Character> getUppers(){
        return this.upperList;
    }
    public ArrayList<Character> getLowers(){
        return this.lowerList;
    }
    public ArrayList<Character> getSpecials(){
        return this.specialList;
    }

    public void fillUpperList(){
        int upperCount = (int)(length * 0.4);

        for(int i = 0; i < upperCount; i++){
            char theUpper = (char)(random.nextInt(26) + 65);
            this.upperList.add(theUpper);
        }
    }
    public void fillLowerList(){
        int lowerCount = (int)(length * 0.4);
        int upperCount = (int)(length * 0.4);
        int specialCount = (int)(length * 0.2);

        if(specialCount + upperCount + lowerCount != length){
            int a = length - (specialCount + upperCount + lowerCount);
            lowerCount = lowerCount + a;
        }

        for(int i = 0; i < lowerCount; i++){
            char theLower = (char)(random.nextInt(26) + 97);
            this.lowerList.add(theLower);
        }
    }
    public void fillSpecialList(){
        int specialCount = (int)(length * 0.2);

        for(int i = 0; i < specialCount; i++){
            char theSpecial = (char)(random.nextInt(15) + 33);
            this.specialList.add(theSpecial);
        }
    }
    
    public char[] shuffleList(){
        fillLowerList();
        fillUpperList();
        fillSpecialList();

        

        int indexListCount = 0;
        indexListCount = 0;
        char[] preList = new char[this.length];
        ArrayList<Character> ArrayPreList = new ArrayList<>();
        
        

        for(int i =  0; i < this.specialList.size(); i++){
            ArrayPreList.add(this.specialList.get(i));
        }
        for(int i =  0; i < this.lowerList.size(); i++){
            ArrayPreList.add(this.lowerList.get(i));
        }
        for(int i =  0; i < this.upperList.size(); i++){
            ArrayPreList.add(this.upperList.get(i));
        }
        
        

        for(int i = 0; i < this.length; i++){
            preList[i] = ArrayPreList.get(i);
        }

        

        char[] mainList = new char[this.length];
        int[] indexList = new int[this.length];

        
        for(int i = 0; i < this.length; i++){
            indexList[i] = i;
        }
        
        
        int mainListCount = 0;
        while(mainListCount < this.length){

            indexListCount = 0;
            for(int element: indexList){
                if (element == -1){
                    indexListCount++;
                }
            }
            
            int rndmIndex = random.nextInt(this.length);
            while(indexList[rndmIndex] == -1){
                rndmIndex = random.nextInt(this.length);
            }
            mainList[rndmIndex] = preList[mainListCount];
            indexList[rndmIndex] = -1;
            mainListCount++;
            
            
        }
        
       
        return mainList;
    }
    
    public void generatePasswords(int length){
        
        char[] mainList = shuffleList();
        this.passwordStr = "";

        for(char element: mainList){
            this.passwordStr = this.passwordStr + element;
        }
    }

}
