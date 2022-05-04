public class CRUD_INSERT {
   public static void main(String[] args) {
      // über die Schnittstelle(UserDao)  auf
      // die konkrete Klasse(UserDaoImpl)  zugreifen.
      UserDao userDao = new UserDaoImpl();
      //erstellen wir vier Benutzer und fügen
      // sie nacheinander in unsere Tabelle "users" ein.
      User user1=new User(1,"Jagjit", "merimann",58);
      User user2=new User(2,"Yudhvir", "meribhai",30);
      User user3=new User(3,"SP Singh", "meripa",63);
      User user4=new User(4,"Rajan SINGH", "mein",32);


      if(userDao.insertUser(user2))
         System.out.println("user2 inserted in Database");
      if(userDao.insertUser(user3))
         System.out.println("user3 inserted in Database");
      if(userDao.insertUser(user4))
         System.out.println("user4 inserted in Database");
      if(userDao.insertUser(user1))
         System.out.println("user1 inserted in Database");
   }
}