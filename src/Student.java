class Student
{
    String sName,sFather,sMother,religion,caste,className,address,gender,sMail;
    int pinNo,rollNo;
    long sPhone;
    public Student(int roll,String name,
                   String cls,long mobile,
                   String gen,String email,
                   String father,String mother,
                   String rel,String add,int pin)
    {
        this.rollNo=roll;
        this.sName=name;
        this.className=cls;
        this.sPhone=mobile;
        this.gender=gen;
        this.sMail=email;
        this.sFather=father;
        this.sMother=mother;
        this.religion=rel;
        this.address=add;
        this.pinNo=pin;
    }

    void getData(int roll,String name,String cls,long mobile,
            String gen,String email,String father,String mother,
                 String rel,String add,int pin)
    {
        this.rollNo=roll;
        this.sName=name;
        this.className=cls;
        this.sPhone=mobile;
        this.gender=gen;
        this.sMail=email;
        this.sFather=father;
        this.sMother=mother;
        this.religion=rel;
        this.address=add;
        this.pinNo=pin;
    }
    void showData()
    {
        System.out.println("Name: "+sName);
        System.out.println("Roll no: "+ rollNo);
        System.out.println("Class: "+className);
        System.out.println("Mobile no: "+ sPhone);
        System.out.println("Gender: "+gender);
        System.out.println("Email: "+sMail);
        System.out.println("Father's name: "+sFather);
        System.out.println("Mother's name: "+sMother);
        System.out.println("Religion: "+religion);
        System.out.println("Address: "+address);
        System.out.println("Pin code: "+pinNo);
    }
}