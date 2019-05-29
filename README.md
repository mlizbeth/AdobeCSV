# AdobeCSV
This is still a work in progress.
In short it takes a CSV with "First name", "last name", "username" as criteria and then converts them into a CSV that can be uploaded to Adobe.
for best results, I prefer to use `sort Filename.csv | uniq >> file.out` on the base file (The CSV we get from a generated report) That way there are no duplicates and values are in alphabetical order for being able to diff your files.

# TODO
remove hardcoded values, make the GUI functional, allow user to set certain variables.
Add sort and diff methods.
