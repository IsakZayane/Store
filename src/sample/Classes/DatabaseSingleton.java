/*
 * Developed at Kristianstad University
 * URL: http://www.hkr.se
 */

package sample.Classes;

/**
 * Used to store the database object created from the class Database.
 * The reason for this Singleton to exist is to avoid having to create
 * the costly Database objects over and over again.
 * 
 * @author Andreas Nilsson (andreas.nilsson@hkr.se)
 */
public class DatabaseSingleton {
    private static DatabaseSingleton ourInstance = new DatabaseSingleton();
    
    private DataBase db;
    
    public static DatabaseSingleton getInstance() {
        return ourInstance;
    }
    
    private DatabaseSingleton() {
    }
    
    public DataBase getDb() {
        return db;
    }
    
    public void setDb(DataBase db) {
        this.db = db;
    }
}
