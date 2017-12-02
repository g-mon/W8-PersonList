import java.util.ArrayList;
public class List{
    private ArrayList<Person> peopleList;
    
    public List(){
        peopleList=new ArrayList<Person>();
    }
    public void addPerson(Person p){
        peopleList.add(p);
    }
    
    public int oldestAge(){
        int size=peopleList.size();
        int index=0;
        Person oldestSoFar;
        oldestSoFar=peopleList.get(0); //otherwise I get an error that it may not have been initialised
        Person ageCurrent;
        while(index<size){
            ageCurrent=peopleList.get(index);
            
            if(ageCurrent.getAge()>oldestSoFar.getAge()){
                oldestSoFar=ageCurrent;
                index++;
            }
            else{
                index++;
            }
        }
        return oldestSoFar.getAge();
        }
    public String oldestName(){
        int size=peopleList.size();
        int index=0;
        Person oldestSoFar;
        oldestSoFar=peopleList.get(0); //otherwise I get an error that it may not have been initialised
        Person ageCurrent;
        while(index<size){
            ageCurrent=peopleList.get(index); //CollectionName.get(index) is now to pick a certain element of the arraylist
            
            if(ageCurrent.getAge()>oldestSoFar.getAge()){
                oldestSoFar=ageCurrent;
                index++;
            }
            else{
                index++;
            }
        }
        return oldestSoFar.getName();
    }
    public int totalAge(){
        int total=0;
        for(Person p: peopleList){ //Now I understand what the middle word is on these loops. It is the label that you use to operate on ie p.getAge below
            total+=p.getAge();
        }
        return total;
    }
    public double meanAge(){
        double total=totalAge();
        double size=peopleList.size();
        double mean=total/size;
        return mean; //why does this still return an integer??? UPDATE: changing total and size to double from int fixed this
    }
}


        
        
       

