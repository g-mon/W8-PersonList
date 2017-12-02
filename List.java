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
    
    public double stanDev(){
        double n=peopleList.size();
        double mean = meanAge();
        double sum=0;
        double value;
        for(Person p: peopleList){
            value=Math.pow(p.getAge()-mean,2);
            sum+=value;
        }
        double result=Math.pow((sum/n),0.5);
        return result;
    }
    
    public void all(){
        Person A=new Person("Alice",38);
        peopleList.add(A);
        Person B=new Person("Benjamin",67);
        peopleList.add(B);
        Person C=new Person("Catherine",53);
        peopleList.add(C);
        Person D=new Person("Delia",19);
        peopleList.add(D);
        
        for(Person p: peopleList){
            System.out.println(p.getName()+" is "+p.getAge()+" years old.");
        }
        System.out.println("");
        System.out.println("The oldest person is "+oldestAge()+" years old");
        System.out.println("The oldest person is "+oldestName());
        System.out.println("The group's total age is "+totalAge());
        System.out.println("The group's mean age is "+meanAge());
        System.out.println("The standard deviation of the group's age is "+stanDev());
    }
    
    public ArrayList<Person> over18(){
        ArrayList<Person> overs=new ArrayList<Person>();
        for(Person p: peopleList){
            if(p.getAge()>=18){
                overs.add(p);
            }
        }
        
        System.out.println("The people over 18 are: ");
        for(Person o: overs){
            System.out.print(o.getName()+", ");
        }
        //Returning the ArrayList alone was unsatisfactory as you wouldn't see the names. Consequently it seemed like a good idea to print their names too.
        return overs;
    }
    public ArrayList<Person> oldestPeople(){
        int max=totalAge();
        ArrayList<Person> maxPeople=new ArrayList<Person>();
        for(Person p: peopleList){
            if(p.getAge()==max){
                maxPeople.add(p);
            }
        }
        for(Person o: maxPeople){
            System.out.print(o.getName()+", ");
        }
        return maxPeople;
    }
    public ArrayList<Person> exceptOldest(){
        ArrayList<Person> except=new ArrayList<Person>();
        for(Person p: peopleList){
            except.add(p);
        }
        for(Person p: oldestPeople()){
            except.remove(p);
        }
        for(Person o: except){
            System.out.print(o.getName()+", ");
        }
        return except;
    }
    
    //LEVEL 3
    
    //for ease of use making method to return oldest person, almost a copy and paste from above. Needs to have the list as a parameter though.
    
    public Person oldestPerson(ArrayList<Person> li){
        int size=li.size();
        int index=0;
        Person oldestSoFar;
        oldestSoFar=li.get(0); //otherwise I get an error that it may not have been initialised
        Person ageCurrent;
        while(index<size){
            ageCurrent=li.get(index);
            
            if(ageCurrent.getAge()>oldestSoFar.getAge()){
                oldestSoFar=ageCurrent;
                index++;
            }
            else{
                index++;
            }
        }
        return oldestSoFar;
    }
        
    
    public double medianAge(){
        //Copy the peopleList into a new ArrayList which can be messed with.
        ArrayList<Person> cloneList=new ArrayList<Person>();
        for(Person p: peopleList){
            cloneList.add(p);
        }
        //Make a new ArrayList of people, entering them oldest first so they're in order
        ArrayList<Person> order=new ArrayList<Person>();
        while(cloneList.size()>0){
            Person b= oldestPerson(cloneList);
            order.add(b);
            cloneList.remove(b);
        }
        //Remove one object either end of the ordered list until only 1 or 2 elements left
        int n;
        while(order.size()>2){
            n=order.size()-1;
            order.remove(0);
            order.remove(n);
        }
        if(order.size()==2){
            double median=(order.get(0).getAge()+order.get(1).getAge())/2;
            return median;
        }
        else{
            double median= order.get(0).getAge();
            return median;
        }
        
    }
}


        
        
       

