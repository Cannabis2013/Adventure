package Adventure.ScreenMessages;

public class MessageBuilder {
    public String buildHelpMsg(){
        return """
                General:
                    help : Print this screen
                    exit : exit game
                    look : Print room description
                
                Movement:
                    Directions: {North, east, south, west}
                    
                                    north
                                      |
                                      |
                              West----O----East
                                      |
                                      |
                                    South
                
                    Go {Direction} : Move player in given direction
                """;
    }

    public String buildIntroMsg(){
        return """
                Welcome to Doom V - A new adventure through hell
                
                In this brand new evolution of Doom, our hero again stands between peace and harmony 
                and total destruction and submission.
                
                The Cyberdemon and the Spider Mastermind has yet again, crawled up from the deep hell 
                to bring havoc on Earth. Only you, a skilled marine from the 5. Bullshit Brigade, has
                what it takes to blast these beasts back to hell, where they belong.
                
                Developers:
                    Programming: Martin Hansen, Stefan "I do not know his middlename" "and his surname"
                    Console formatting: Martin Hansen
                    Ideas: Martin, Stefan
                    
                Copyright: Nope, but we sure damn gets pissed if someone dares to steal our product.""";
    }
    public String buildPressKeyMsg(){return "Press any key to continue";}
    public String buildBadInventoryPick(String itemTitle){return String.format("You don't have anything like %s in your inventory",itemTitle);}
    public String buildBadRoomPick(String itemTitle){return String.format("There is nothing like %s to take around here",itemTitle);}
    public String buildRoomDescription(String description){return description + "\n\n";}
    public String buildBadCommand(){return "!!!! Bad command. Please try again. !!!!";}

    public String buildBadDirection(){return "you can not go that way";}
    public String buildLocked() {return "Door is locked";}
    public String buildWrongKey() {return "Wrong key";}
    public String buildItemNotInInventory() {return "You don't posses that item";}
    public String buildDoorNotFound() {return "there is no door at that orientation";}
    public String buildDoorUnlocked() {return "Door is open";}
}
