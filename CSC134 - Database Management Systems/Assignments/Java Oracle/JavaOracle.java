package Main;

import java.util.Scanner;

import java.sql.*;

class Driver {
	private static String command;
	Scanner scanner = new Scanner(System.in);
	static Driver driver = new Driver();

	public static void main(String[] args) throws Exception {
		boolean activePrompt = true;

		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@sabzevi2.homeip.net:1521:orcl", "csus",
				"student");
		Statement st = con.createStatement();
		
		//DROP ANY EXISTING TABLES AND RE-CREATE TABLES FOR NEW SESSION
		try {
			st.executeQuery("DROP TABLE amele_movies");
		} catch (SQLException s) {
		}
		try {
			st.executeQuery("DROP TABLE amele_studios");
		} catch (SQLException s) {
		}
		try {
			st.executeQuery("DROP SEQUENCE amele_movieids_seq");
		} catch (SQLException s) {
		}
		
		//CREATE SEQEUNCE FOR PRIMARY KEY
		st.executeQuery("CREATE TABLE amele_studios (studio VARCHAR(30))");
		st.executeQuery("CREATE TABLE amele_movies (movid NUMBER, name VARCHAR(30), released DATE, studio VARCHAR(30))");
		st.executeQuery("CREATE SEQUENCE amele_movieids_seq START WITH 1");
		//ANND PRIMARY KEY AND LINK FOREIGN KEYS
		st.executeQuery("ALTER TABLE amele_movies ADD CONSTRAINT amele_mov_pk PRIMARY KEY (movid)");
		st.executeQuery("ALTER TABLE amele_studios ADD CONSTRAINT amele_std_pk PRIMARY KEY (studio)");
		st.executeQuery("ALTER TABLE amele_movies ADD CONSTRAINT amele_mov_std_fk FOREIGN KEY (studio) REFERENCES amele_studios ON DELETE CASCADE DEFERRABLE INITIALLY IMMEDIATE");
		
		
		//PRINT PROGRAM PROMPT
		driver.Prompt();
		
		while (activePrompt) {
			//COMMAND ENTERED: INSERT
			if (Integer.parseInt(command) == 1) {
				activePrompt = false;
				
				try {
					driver.Insert();
				} catch (SQLException s) {
					System.out.println("SQL Error! \n\n");
					System.out.println(s);
				}

				activePrompt = true;
				driver.Prompt();
			}
			//COMMAND ENTERED: DELETE
			else if (Integer.parseInt(command) == 2) {
				activePrompt = false;

				try {
					st.executeQuery(driver.Delete());
				} catch (SQLException s) {
					System.out.println("SQL Error! \n\n");
					System.out.println(s);
				}

				activePrompt = true;
				driver.Prompt();
			}
			//COMMAND ENTERED: UPDATE
			else if (Integer.parseInt(command) == 3) {
				activePrompt = false;
				
				try {
					driver.Update();
				} catch (SQLException s) {
					System.out.println("SQL Error! \n\n");
					System.out.println(s);
				}
				
				activePrompt = true;
				driver.Prompt();
			} 
			//COMMAND ENTERED: VIEW
			else if (Integer.parseInt(command) == 4) {
				activePrompt = false;

				try {
					driver.View();
				} catch (SQLException s) {
					System.out.println("SQL Error! \n\n");
					System.out.println(s);
				}

				activePrompt = true;
				driver.Prompt();
			} 
			//COMMAND ENTERED: QUIT
			else if (Integer.parseInt(command) == 5) {
				activePrompt = false;
				System.out.println("PROGRAM ENDED!");
				
				st.executeQuery("DROP TABLE amele_movies");
				st.executeQuery("DROP TABLE amele_studios");
				st.executeQuery("DROP SEQUENCE amele_movieids_seq");
				
				System.exit(0);
			} 
			//COMMAND ENTERED: ERROR
			else {
				System.out.println("Error! Please enter a valid command.");
				driver.Prompt();
			}
		}
	}

	private void Insert() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@sabzevi2.homeip.net:1521:orcl", "csus",
				"student");
		Statement st = con.createStatement();

		String SQLString = null;

		System.out.println("Table name: (amele_movies OR amele_studios)");
		String table = scanner.nextLine();
		
		//IF INSERTING INTO amele_movies
		
		if (table.equals("amele_movies")) {
			System.out.println("Movie Name:");
			String name = scanner.nextLine();
			System.out.println("Date Released: (FORMAT: DD-MON-YY)");
			String released = scanner.nextLine();
			System.out.println("Studio Name:");
			String studio = scanner.nextLine();
			
			//USE PROMPTS TO FILL IN VALUES
			SQLString = "INSERT INTO " + table + " VALUES (amele_movieids_seq.nextval,'" + name + "','" + released + "','" + studio + "')";
			
			ResultSet rs = st.executeQuery("SELECT * FROM amele_studios");
			int count = 0;
			//IF STUDIO DOESNT ALREADY EXIST, CREATE NEW ENTRY IN amele_studios FOR NEW STUDIO
			while (rs.next()) {
				if (rs.getString(1).equals(studio)) {
					count += 1;
				}
			}
			rs.close();
			if (count == 0) {
				st.executeQuery("INSERT INTO amele_studios VALUES ('" + studio + "')");
			}
		st.executeQuery(SQLString);
		} 
		//IF INSERTING INTO amele_studios
		else if (table.equals("amele_studios")) {
			System.out.println("Studio Name:");
			String studio = scanner.nextLine();

			//CHECK IF ENTRY ALREADY EXISTS
			ResultSet rs = st.executeQuery("SELECT * FROM amele_studios");
			int count = 0;
			while (rs.next()) {
				if (rs.getString(1).equals(studio)) {
					count += 1;
				}
			}
			rs.close();
			//IF ENTRY DOESNT EXIST, USE PROMPTS TO FILL IN VALUES
			if(count == 0) {
				SQLString = "INSERT INTO " + table + " VALUES ('" + studio + "')";
				st.executeQuery(SQLString);
			}
			else {
				System.out.println("Error. An entry with that name already exists! \n Please try again.");
				driver.Insert();
			}
		} 
		else {
			//ELSE ERROR
			System.out.println("Error. Please enter a valid tablename!");
			driver.Insert();
		}
	}

	private String Delete() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@sabzevi2.homeip.net:1521:orcl", "csus",
				"student");
		Statement st = con.createStatement();

		String SQLString = null;

		System.out.println("Table name: (amele_movies OR amele_studios)");
		String table = scanner.nextLine();
		
		//IF DELETEING FROM amele_movies
		if (table.equals("amele_movies")) {
			System.out.println("Movie ID:");
			String movieid = scanner.nextLine();

			SQLString = "DELETE FROM  " + table + " WHERE movid='" + movieid + "'";
			
			ResultSet rs2 = st.executeQuery("SELECT * FROM amele_movies WHERE movid='" + movieid + "'");
			String studio = null;
			while (rs2.next()) {
				studio = rs2.getString(4);
			}
			
			ResultSet rs = st.executeQuery("SELECT * FROM amele_movies");

			// IF DELETED MOVIE WAS LAST ENTRY FOR STUDIO, DELETE STUDIO TOO
			int count = 0;
			while (rs.next()) {
				if (rs.getString(4).equals(studio)) {
					count += 1;
				}
			}
			rs.close();

			if (count <= 1) {
				st.executeQuery("DELETE FROM amele_studios WHERE studio='" + studio + "'");
			}
		} 
		//IF DELETEING FROM amele_studios
		else if (table.equals("amele_studios")) {
			System.out.println("Studio Name:");
			String studio = scanner.nextLine();
			
			//USE PROMPT TO REMOVE VALUES IN amele_studio
			//DELETE CASCADE SHOULD REMOVE ALL CHILD ENTRIES IN amele_movies WHEN DELETED
			SQLString = "DELETE FROM  " + table + " WHERE studio='" + studio + "'";
					
		} 
		//ELSE ERROR
		else {
			System.out.println("Error. Please enter a valid tablename!");
			driver.Delete();
		}

		return SQLString;
	}

	private void Update() throws SQLException{
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@sabzevi2.homeip.net:1521:orcl", "csus",
				"student");
		Statement st = con.createStatement();
		
		System.out.println("Enter Studio Name You Want To Update:");
		String studio = scanner.nextLine();
		System.out.println("Enter New Studio Name:");
		String newstudio = scanner.nextLine();
		
		//UPDATE GIVEN ENTRY BASED ON PROMPTS
		
		
		st.executeQuery("ALTER TABLE amele_movies DISABLE CONSTRAINT amele_mov_std_fk");
		st.executeQuery("UPDATE amele_movies m SET m.studio='" + newstudio + "' WHERE m.studio='" + studio + "'");
		st.executeQuery("UPDATE amele_studios s SET s.studio='" + newstudio + "' WHERE s.studio='" + studio + "'");
		st.executeQuery("ALTER TABLE amele_movies ENABLE CONSTRAINT amele_mov_std_fk");
	}

	private void View() throws SQLException{
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@sabzevi2.homeip.net:1521:orcl", "csus",
				"student");
		Statement st = con.createStatement();

		//PRINT amele_movies (WITHOUT PRIMARY KEY) SHOW FOREIGN KEY LINK
		ResultSet rs = st.executeQuery("SELECT * FROM amele_movies");
		System.out.println("MOVIE TABLE:");
		while (rs.next()) {
			System.out.print(rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + "\n");
		}
		rs.close();
		System.out.println("\n\n\n");
	}

	private void Prompt() {
		//BASIC PROMPT DEFINITION FOR PROGRAM
		System.out.println("Enter a command: \n 1) Insert\n 2) Delete\n 3) Update\n 4) View\n 5) Quit\n");
		Driver.command = scanner.nextLine();
	}
}
