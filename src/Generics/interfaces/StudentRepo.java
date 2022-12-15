package Generics.interfaces;

public class StudentRepo implements Repository<Student>{
    @Override
    public void add(Student student) {
        System.out.println(student.getName()+ "Basariyla kaydedildi");

    }

    @Override
    public void get(Student student) {
        System.out.println(student.getName()+"basariyla bulundu");

    }

    @Override
    public void update(Student student) {
        System.out.println(student.getName()+"basariyla güncellendi"+ student.getName()+"update");

    }

    @Override
    public void delete(Student student) {
        System.out.println(student.getName()+"basariyla silindi");
    }
}
