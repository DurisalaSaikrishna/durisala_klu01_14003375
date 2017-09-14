import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		return students;
	}

	@Override
	public void setStudents(Student[] students) throws IllegalArgumentException{
		// Add your implementation here
                if(students==null)
                this.students = students;
                else
                throw new IllegalArgumentException();
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
                if(index<0 || index>=students.length)
                    throw new IllegalArgumentException();
                else 
                    return students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
                if(student==null)
                     throw new IllegalArgumentException();
                else if(index<0 || index>=students.length)
                     throw new IllegalArgumentException();
                else students[index]=student;
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
                if(student==null)
                     throw new IllegalArgumentException();
                
                Student students1[]=new Student[students.length + 1];
                students1[0]=student;
                for(int i=1;i<students1.length;i++){
                    students1[i]=students[i-1];
                }
                students=students1;
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
                if(student==null) 
                    throw new IllegalArgumentException();
                Student [] students1=new Student[students.length+1];
                students1[students1.length - 1]=student;
                for(int i=0;i<students.length;i++){
                    students1[i]=students[i];
                }
                students=students1;
	}

	@Override
	public void add(Student student, int index) throws IllegalArgumentException {
		// Add your implementation here
               if(student==null)
                     throw new IllegalArgumentException();
                else if(index<0 || index>=students.length)
                     throw new IllegalArgumentException();
                else students[index]=student;
                
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
                if(index<0 || index>=students.length)
                     throw new IllegalArgumentException();
                else{
                Student[] students1=new Student[students.length-1];
                for(int i=0,j=0;i<index;i++,j++){
                    students1[j]=students[i];
                }
                for(int i=index+1,j=index;i<students1.length;i++,j++){
                    students1[j]=students[i];
                }
                students=students1;
                }
             
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
                if(student==null){
                    throw new IllegalArgumentException();
                }
                else{
                    boolean exists=false;
                    for(int i=0;i<students.length;i++){
                        if(students[i]==student){
                            int index=i;
                            exists=true;
                             Student[] students1=new Student[students.length-1];
                              for(int j=0,k=0;j<index;j++,k++){
                               students1[k]=students[j];
                               }
                              for(int j=index+1,k=index;j<students1.length;k++,j++){
                                students1[k]=students[j];
                               }
                         students=students1;
                         break;
                        }  
                    }
                    if(exists==false){
                        try {
                            throw new IllegalArgumentException();
                        }catch(IllegalArgumentException e){
                           System.out.println("Student not found" +e);
                        }
                    }
                }
        }

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
                if(index<0 || index>=students.length)
                    throw new IllegalArgumentException();
                else{
                index=students.length - index;
                index=students.length - index;
                Student [] students1=new Student[index];
                students1=java.util.Arrays.copyOf(students,index);
                students=students1;
                }
	}

	@Override
	public void removeFromElement(Student student) throws IllegalArgumentException{
		// Add your implementation here
                if(student==null){
                    throw new IllegalArgumentException();
                }
                else{
                    int index=0,index1=students.length;
                     for(int i=0;i<students.length;i++){
                     if(students[i]==student){
                         index1=i;break;
                     }
                     
                     }
                     if(index==students.length)
                         System.out.println("Student not found");
                     else
                     {
                      index=students.length - index;
                      Student [] students1=new Student[index];
                      for(int i=index;i<students.length;i++){
                          
                      }
                      students=students1;
                     }
                }
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
                index=students.length - index;
                index=students.length - index;
                Student [] students1=new Student[index];
                for(int i=index,j=0;i<students.length;i++,j++){
                    students1[j]=students[i];
                }
                students=students1;
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
                if(student==null){
                    throw new IllegalArgumentException();
                }
                else{
                     int index=students.length;
                     for(int i=0;i<students.length;i++){
                     if(students[i]==student){
                         index=i;break;
                     }
                     }
                index=students.length - index;
                index=students.length - index;
                Student [] students1=new Student[index];
                for(int i=index,j=0;i<students.length;i++,j++){
                    students1[j]=students[i];
                }
                students=students1;   
	}
        }

	@Override
	public void bubbleSort() {
		// Add your implementation here
               StudentGroup.bubbleSort(students);
	}
        static void bubbleSort(Student[] arr) {  
        int n = arr.length;  
        int temp = 0;  
         for(int i=0; i < n; i++){  
                 for(int j=1; j < (n-i); j++){  
                          if(arr[j-1].getId() > arr[j].getId()){
                                 temp = arr[j-1].getId();  
                                 arr[j-1].setId(arr[j].getId());  
                                 arr[j].setId(temp);  
                         }  
                 }  
         }
        }  

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
                if(date==null) throw new IllegalArgumentException();
                else{
                int count=0;
                for(int i=0;i<students.length;i++){
                 if (date.compareTo(students[i].getBirthDate()) < 0) {
                    count++;  
                 }
                }
                Student students1[]=new Student[count];
                for(int i=0,j=0;i<students.length;i++){
                 if (date.compareTo(students[i].getBirthDate()) < 0) {
                    students1[j]= students[i];
                    j++;
                 }
                }
		return students1;
	    }
        }

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
                if(firstDate==null || lastDate==null) throw new IllegalArgumentException();
                else{int count=0;
                for(int i=0;i<students.length;i++){
                 if ((firstDate.compareTo(students[i].getBirthDate()) < 0 )&&(lastDate.compareTo(students[i].getBirthDate()) > 0)) {
                    count++;  
                 }
                }
                Student []students1=new Student[count];
                for(int i=0,j=0;i<students.length;i++){
                 if ((firstDate.compareTo(students[i].getBirthDate()) < 0 )&&(lastDate.compareTo(students[i].getBirthDate()) > 0)) {
                    students1[j]=students[i];j++;
                 }
                }
		return students1;
                }
	}
	@Override
	public Student[] getNearBirthDate(Date date, int days)  {
		// Add your implementation here
                 Student [] students1=new Student[students.length];
                if(date==null) throw new IllegalArgumentException();
                
                else{
                   int count=0;
                  
                   for(int i=0,j=0;i<students.length;i++){
                try{
                String sDate1=StudentGroup.getnext(String.valueOf(date));
                Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1); 
                if(date.compareTo(date1) > 0 && (-(date.compareTo(date1)) <= days)){
                   count++;
                   students1[j]=students[i];j++;
                }
                }
                catch(Exception e){
                    System.out.println("date format exception");
                }
              }
                   Student[] student2=new Student[count];
                   for(int i=0;i<students.length;i++){
                       student2[i]=students1[i];
                   }
                   
		return student2;
                }
	}
        public static String getnext(String curDate) throws Exception{
             final SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
             final Date date = format.parse(curDate);
             final Calendar calendar = Calendar.getInstance();
             calendar.setTime(date);
             calendar.add(Calendar.DAY_OF_YEAR, 1);
             return format.format(calendar.getTime()); 
        }
	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
                if(indexOfStudent==0) throw new IllegalArgumentException();
                else{
                LocalDate today = LocalDate.now();
                ZoneId defaultZoneId = ZoneId.systemDefault();
                Instant instant =students[indexOfStudent].getBirthDate().toInstant();
                LocalDate birthday = instant.atZone(defaultZoneId).toLocalDate();
                Period p = Period.between(birthday, today);
		return p.getYears();
	   }
        }
	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here 
                int count=0;
                for(int i=0;i<students.length;i++){
                    if(age==getCurrentAgeByDate(i)){
                        count++;
                    }
                }
                Student [] std=new Student[count];
                for(int i=0,j=0;i<students.length;i++){
                    if(age==getCurrentAgeByDate(i)){
                       std[j]=students[i];j++;
                    }
                }
		return std;
	}
	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
                  double max=0;
                  int count=0;    
                for(int i=0;i<students.length;i++){
                    if(max<students[i].getAvgMark()){
                        max=students[i].getAvgMark();
                    }
                }
                for(int i=0;i<students.length;i++){
                    if(max==students[i].getAvgMark()){
                        count++;
                    }
                }
                Student[] std=new Student[count];
                for(int i=0,j=0;i<students.length;i++){
                     if(max==students[i].getAvgMark()){
                        std[j]=students[i];j++;
                    }
                }
		return std;
	}
	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here    
                int index=0;

                if(student==null) throw new IllegalArgumentException();
                else{
                    for(int i=0;i<students.length;i++){
                        if(student==students[i]){
                            index=i+1;
                        }
                    }
                    
                }
		return students[index];
	}
}
