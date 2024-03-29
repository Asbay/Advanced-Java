package Generics.interfaces;

/*Task: Okul yönetimi için öğrenci ve öğretmen kayıtlarını
   -oluşturan
   -görüntüleyen
   -güncelleyen
   -silen
   bir program yazınız.
 */
public class SchoolManagement {

    public static void main(String[] args) {
        Student student = new Student("Tolstoy");
        StudentRepo studentRepo =new StudentRepo();
        Teacher teacher=new Teacher("Dostoyevski");
        TeacherRepo teacherRepo= new TeacherRepo();

        studentRepo.add(student);
        studentRepo.update(student);
        studentRepo.get(student);
        studentRepo.delete(student);
        System.out.println();

        teacherRepo.add(teacher);
        teacherRepo.update(teacher);
        teacherRepo.get(teacher);
        teacherRepo.delete(teacher);


    }
}
