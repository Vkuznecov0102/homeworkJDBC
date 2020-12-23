import dao.EmployerDAO;
import implementations.EmployerDAOImpl;

public class Main {

    public static void main(String[] args) {
        EmployerDAO dao=new EmployerDAOImpl();
        System.out.println("dao.getAgeByUserName(\"tanya\") = " + dao.getAgeByUserName("tanya"));
    }
}
