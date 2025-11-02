### 🧮 Setup the local PostgreSQL database

1. Install PostgreSQL and make sure the server is running.
2. Create a new database, e.g.:
    ```sql
    CREATE DATABASE db_name;
    ```
3. Execute schema.sql from this directory(same directory as this README.md) script using `psql`, for example:
    ```bash
    psql -U your_username -d gameagg_db -f /path/to/schema.sql
    ```  
   Replace `your_username`, `db_name`, and the path as applicable.

4. Connect to the database and verify that the tables exist:
    ```bash
    psql -U your_username -d gameagg_db
    \dt
    ```  
5. If you encounter permission or authentication errors, ensure the user has the needed privileges or try running with a superuser.
