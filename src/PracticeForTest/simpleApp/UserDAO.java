package PracticeForTest.simpleApp;

public class UserDAO {
    public String getUserById(int id) throws DataAccessException{
        try{
            if(id == 1){
                throw new RuntimeException("Simulated database connection error");

            }
            return "User Found: Bablu";
        }catch (RuntimeException e){
            //wrapping the original exception into a custom checked exception
            throw new DataAccessException("Failed to access data for user id: "+id, e);
        }
    }
}
