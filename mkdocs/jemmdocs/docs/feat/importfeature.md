# 📥 Import CSV Metadata – Apply Bulk Changes with Ease#

The Import CSV Metadata feature in JEMM allows users to apply massive metadata updates across multiple libraries—all in one go. It’s the perfect tool for those who prefer editing outside the app using familiar tools like Microsoft Excel, Notepad++, Visual Studio Code, or Sublime Text.

## 🧩 How It Works ##

After exporting your metadata using the Export CSV Metadata function, you can open the file and make changes to any fields you need—titles, genres, artwork links, descriptions, and more.

### Once your edits are complete: ###

 - Select the CSV file you’ve modified.

 - JEMM will read the file and match each row to its corresponding item in your Jellyfin libraries.

 - A message indicating the differences found between the original values ​​and the new ones (those edited in the imported CSV) will be displayed.

 - Before applying the changes, you can check a log to better visualize the differences.

 - After you confirm the changes, all valid changes will be applied automatically—saving you hours of manual editing.

 - After the Import process is complete, you can review all applied changes through a process log file, which provides a detailed summary of what was updated—giving you full transparency and traceability.


### ✅ Smart and Flexible ###

 You don’t need to edit every row—just keep the ones you’ve changed. JEMM will ignore unchanged entries and focus only on what’s new. This makes it ideal for targeted updates, or syncing metadata across multiple libraries.

### ⚠️ Important Reminder ###

To ensure a smooth import:

 - CSV files exported and imported to JEMM consider ";" (semicolon) as the delimeter/separator char. Don't try use other ones.
 - Pay Attention: By default, MS-Excel uses "," (comma) as the default delimeter/separator char when you save/create a new file from MS-Excel.
 - Do not change the order of the columns in the CSV file.
 - Never (I repeat: Never) change the values ​​corresponding to the "Id" and "ParentId" fields. They are necessary to establish the correct relationship between the "CSV row" and the "item stored in the Jellyfin database."
 - Keep the original structure intact so JEMM can correctly interpret your changes.

Whether you're fixing a few typos or reworking an entire media collection, the Import CSV Metadata feature gives you the power to do it quickly, accurately, and on your terms.