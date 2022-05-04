public class CRUD_READ {
   public static void main(String[] args) {
      // über die Schnittstelle(UserDao)  auf
      // die konkrete Klasse(UserDaoImpl)  zugreifen.
      UserDao userDao = new UserDaoImpl();
      //Holen Sie sich den Benutzer mit der id =1
      //und zeigen Sie seine Details an
      try{
         User u2=userDao.getUser(2);
         System.out.println(u2.getId()+"\t"+u2.getName()+"\t"+u2.getPass()+"\t"+u2.getAge());
      }
      catch (NullPointerException e)
      {
         System.out.println("NULL");
      }


   }
}