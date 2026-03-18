---
  layout: default.md
  title: "User Guide"
  pageNav: 4
---

# Hairy Pawter User Guide

Hairy Pawter is a desktop app that helps you store details of clients and pets.
You can register clients and their pets, so that after grooming a pet, you can find the details of the owner and contact them.

<!-- * Table of Contents -->
<page-nav-print />

--------------------------------------------------------------------------------------------------------------------

## Installation

1. [Install Java `17` or higher to your computer](https://se-education.org/guides/tutorials/javaInstallation.html).

1. Click on `tp.jar` to download it from [here](https://github.com/AY2526S2-CS2103T-F14-2/tp/releases).

1. Move `tp.jar` to the folder you want to use as the _home folder_ for this app.

1. Open a command terminal (Command Prompt for Windows, Terminal for Mac)

1. In the command terminal, enter the command `cd PATH` where PATH is the location of _home folder_ (e.g. `cd C:\Users\jeff\Desktop\HairyPawter\`)

1. In the command terminal, enter the command `java -jar tp.jar` to start the app.<br>
![Ui](images/Ui.png)

--------------------------------------------------------------------------------------------------------------------

## Commands

In the app, type a command in the command box and press Enter to execute it. (e.g. typing **`help`** and pressing Enter will open the help window)<br>

<box type="info" seamless>

**Reading the command guide:**<br>

* Words in `UPPER_CASE` should be replaced with real values.<br>
  e.g. `client n/NAME` should be used as `client n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `[t/TAG]` can be ignored.

* Items with `…`​ can be used multiple times.<br>
  e.g. `[t/TAG]…​` can be used as `t/friend t/family`

* Inputs can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
</box>

### Viewing help : `help`

Shows a message explaining how to access the help page.

![help message](images/helpMessage.png)

Format: `help`


### Adding a client: `client`

Registers a new client.

Format: `client n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​`

<box type="tip" seamless>

**Tip:** Clients can have the same name, but never the same phone number
</box>

Examples:
* `client n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01`
* `client n/Betsy Crowe t/friend e/betsycrowe@example.com a/Crown street p/1234567`

### Adding a pet: `pet`

Registers a new pet of a client. The name of the pet and the phone number of the client are needed.

Format: `pet n/NAME p/PHONE_NUMBER​ [s/SPECIES] [b/BREED]`

Examples:
* `pet n/Snowy p/0000 s/Dog b/Wire Fox Terrier (White)`
* `pet n/Meowy p/123456`

### Listing all clients and pets : `list`

Shows all clients and pets.

Format: `list`

### Editing a client : `edit`

Edits an existing client.

Format: `edit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`

* Edits the person at the specified `INDEX`. The index refers to the index number shown in the displayed person list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the person will be removed i.e adding of tags is not cumulative.
* You can remove all the person’s tags by typing `t/` without
    specifying any tags after it.

Examples:
*  `edit 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st person to be `91234567` and `johndoe@example.com` respectively.
*  `edit 2 n/Betsy Crower t/` Edits the name of the 2nd person to be `Betsy Crower` and clears all existing tags.

### Locating clients by name: `find`

Finds clients whose names contain any of the given keywords.

Format: `find KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `hans` will match `Hans`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* Only the name is searched.
* Only full words will be matched e.g. `Han` will not match `Hans`
* Persons matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`

Examples:
* `find John` returns `john` and `John Doe`
* `find alex david` returns `Alex Yeoh`, `David Li`<br>
  ![result for 'find alex david'](images/findAlexDavidResult.png)

### Deleting a client : `deleteClient`

Deletes the specified client.

Format: `deleteClient INDEX`

* Deletes the client at the specified `INDEX`.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd person in the address book.
* `find Betsy` followed by `delete 1` deletes the 1st person in the results of the `find` command.


### Deleting a pet : `deletePet`

Deletes the pet with the specified name, belonging to the owner with the phone number.

Format: `deletePet n/NAME p/PHONE_NUMBER`

Examples:
* `deletePet n/Snowy p/0000`
* `deletePet n/Meowy p/123456`

### Clearing all records : `clear`

Clears all records from memory.

Format: `clear`

### Exiting the app : `exit`

Exits the app.

Format: `exit`

### Saving the data

Data is saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

Data is saved automatically as a JSON file `[tp.jar file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

<box type="warning" seamless>

**Caution:**
If your changes to the data file makes its format invalid, the entire file will be discarded the next time the app is opened.  Hence, it is recommended to take a backup of the file before editing it.<br>
Furthermore, certain edits can cause the app to behave in unexpected ways (e.g., if a value entered is outside the acceptable range). Therefore, edit the data file only if you are confident that you can update it correctly.
</box>

### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.
2. **If you minimize the Help Window** and then run the `help` command (or use the `Help` menu, or the keyboard shortcut `F1`) again, the original Help Window will remain minimized, and no new Help Window will appear. The remedy is to manually restore the minimized Help Window.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action     | Format, Examples
-----------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------
**Client**    | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​` <br> e.g., `add n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 t/friend t/colleague`
**Clear**  | `clear`
**DeleteClient** | `delete INDEX`<br> e.g., `delete 3`
**Edit**   | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com`
**Find**   | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find James Jake`
**Help**   | `help`
**List**   | `list`

