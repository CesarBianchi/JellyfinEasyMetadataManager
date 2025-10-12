# 📤 How to Use the "Export" CSV Metadata Function#

The Export CSV Metadata feature in JEMM allows you to generate a complete metadata file for your libraries — all in a clean, editable CSV format.

## Using it is simple: ##

 - 🗂️ Choose a Destination Path Select the folder or location on your computer where you want the CSV file to be saved. This will be the output path for the exported metadata.

- 📄 Confirm and Export Once the path is selected, JEMM will automatically generate the CSV file containing all current metadata from your Jellyfin libraries.

### 📂 What Happens After Export? ###

Once the Export CSV Metadata process is complete, the generated file will be automatically opened using the default CSV viewer configured on your machine.

Whether it's Microsoft Excel, LibreOffice Calc, or a text editor like Notepad++, JEMM will launch the file so you can immediately review or start editing your metadata—no extra steps needed.

The exported file can be opened and edited also in tools like Microsoft Excel, Notepad++, Visual Studio Code, or Sublime Text, giving you full flexibility to review or modify metadata outside the app.

Once you're done editing, you can re-import the file using the Import CSV Metadata function to apply your changes back into Jellyfin.

### **⚠️ Important Info** ###

Do not change the order of the columns in the CSV file. Altering the field sequence may cause errors during the import process, and JEMM won’t be able to correctly match your metadata to the corresponding items.

To ensure a smooth import, always keep the original column structure intact—even if you're only editing rows.