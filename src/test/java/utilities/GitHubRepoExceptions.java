package utilities;

public class GitHubRepoExceptions extends Exception {
 
	public GitHubRepoExceptions(String message) {
        super(message);
    }

    public GitHubRepoExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}