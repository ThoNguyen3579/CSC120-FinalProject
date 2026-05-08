import java.util.ArrayList;

class Maze {
    ArrayList<Cell> listOfCells;

    /**
     * Constructor initializing our maze as a list of list (cells) of integers (wall)
     */
    public Maze(){
        this.listOfCells = new ArrayList<Cell>(); // a 2D list
    }


    /** Add into the list of cells the cell with custom walls
     * for each cell, 1 = have wall, 0 = no wall, and we do this for each edge of the cell
     * @param leftWall
     * @param upWall
     * @param rightWall
     * @param downWall
     */
    public void addCellVal(int leftWall, int upWall, int rightWall, int downWall, boolean heartRoom, boolean diamondRoom){
        // add a new cell with their walls
        // 0 represents no wall, 1 represents wall 
        Cell cell_i = new Cell(leftWall, upWall, rightWall, downWall, heartRoom, diamondRoom);

        // add this cell into the maze list
        this.listOfCells.add(cell_i); 

        // print the maze beautifully
        if (leftWall == 1){ 
            System.out.print("|"); // print "|" to represent wall
        } else if (leftWall == 0){ 
            System.out.print(" "); // print " " to represent no wall
        }

        if (downWall == 1){
            System.out.print("_"); // // print "_" to represent wall
        } else if (downWall == 0){
            System.out.print(" "); //// print " " to represent no wall
        }
    }

    /**
     * Add all the cells into the maze
     * Print a nicely formatted maze 
     */
    public void buildMaze(){
        /**
         * Create cells and add them to the maze
         */
        System.out.println("   _ _ _ _ _ _");
        // row 1
        this.addCellVal(1,0,1,0, false, false);
        this.addCellVal(1,1,0,0,false, false);
        this.addCellVal(0,1,0,1,false, false);
        this.addCellVal(0,1,0,1,false, false);
        this.addCellVal(0,1,0,0,false, false);
        this.addCellVal(0,1,0,1,false, false);
        this.addCellVal(0,1,1,0,false, false);
        System.out.print("|");

        // row 2
        System.out.println();
        this.addCellVal(1,0,1,0,false, false);
        this.addCellVal(1,0,0,1,false, false);
        this.addCellVal(0,1,0,1,false, true); // Diamond Room 1
        this.addCellVal(0,1,1,0,false, false);
        this.addCellVal(1,0,1,0,false, false);
        this.addCellVal(1,1,0,0,false, false);
        this.addCellVal(0,0,1,0,false, false);
        System.out.print("|");

        // row 3
        System.out.println();
        this.addCellVal(1,0,1,0,true, false); //main bedroom + bathroom; location = 14
        this.addCellVal(1,1,0,0,false, false);
        this.addCellVal(0,1,0,0,false, false);
        this.addCellVal(0,0,1,1,false, false);
        this.addCellVal(1,0,1,0,false, true); // diamond room 2
        this.addCellVal(1,0,0,1,false, false);
        this.addCellVal(0,0,1,0,false, false);
        System.out.print("|");

        // row 4
        System.out.println();
        this.addCellVal(1,0,1,0,false, false);
        this.addCellVal(1,0,1,0,true, false); // kitchen; location = 22
        this.addCellVal(1,0,1,0,false, false);
        this.addCellVal(1,1,1,0,false, true); // diamond room 3
        this.addCellVal(1,0,1,0,false, false);
        this.addCellVal(1,1,0,1,false, false);
        this.addCellVal(0,0,1,1,false, false);

        // row 5
        System.out.println();
        this.addCellVal(1,0,0,1,false, false);
        this.addCellVal(0,0,1,1,false, false);
        this.addCellVal(1,0,1,0,true, false); // office; location = 30
        this.addCellVal(0,0,0,1,false, false);
        this.addCellVal(0,0,1,1,false, false);
        this.addCellVal(1,1,0,0,false, false);
        this.addCellVal(0,1,1,0,false, false);
        System.out.print("|");

        // row 6
        System.out.println();
        this.addCellVal(1,1,0,0,false, false);
        this.addCellVal(0,1,0,1,false, false);
        this.addCellVal(0,0,1,1,false, false);
        this.addCellVal(1,1,0,0,false, false);
        this.addCellVal(0,1,0,0,false, false);
        this.addCellVal(0,0,1,0,false, false);
        this.addCellVal(1,0,1,0,false, false);
        System.out.print("|");

        // row 7
        System.out.println();
        this.addCellVal(1,0,0,1,false, false);
        this.addCellVal(0,1,0,1,false, false);
        this.addCellVal(0,1,0,1,false, false);
        this.addCellVal(0,0,1,1,false, false);
        this.addCellVal(1,0,0,1,true, false); // children's room; location = 46
        this.addCellVal(0,0,1,1,false, false);
        this.addCellVal(1,0,1,0,false, false);
    }

     /**
     * create searchable objects and then add them into the rooms so that the player can interact with them
     */
    public void addSearchableObject(){
        // ________________ HEART ROOM ___________________
        // bathroom
        searchableObject clothes = new searchableObject("CLOTHES", "Tieu Lau picked them up and examined them carefully; although they resembled bloodstains, in reality, they were not. These marks did not match the bloodstains found on the victim's nightgown. The soiled clothing bore several stains that resembled blood; however, a professional analysis revealed that they were not blood at all, but rather appeared to be fruit juice. Tieu Lau meticulously checked the pockets, but found nothing else.", 5);
        
        searchableObject trashcan = new searchableObject("TRASH CAN", "Without hesitation, Tieu Lau turned the trash can upside down and emptied all the trash onto the floor. He found some scraps of paper. Tieu Lau quickly brushed aside the dirty toilet paper, sifting through the torn pieces. He pieced them together, and surprisingly, he formed a complete picture - a photograph of a marriage certificate.");
        searchableObject marriageCertificate = new searchableObject("MARRIAGE CERTIFICATE", null, 10);
        // add objects to bathroom
        this.listOfCells.get(14).objects.add(clothes);
        this.listOfCells.get(14).objects.add(trashcan);
        this.listOfCells.get(14).objects.add(marriageCertificate);

        // main bedroom
        searchableObject wardrobe = new searchableObject("WARDROBE", "As Tieu Lau threw open the wardrobe, he rapidly analyzed the situation in his mind. The torn photograph of the marriage certificate, discarded in the bathroom trash, indicated that the female occupant's marriage had crumbled; yet, the presence of men's clothing and shoes within the residence suggested that the couple had not yet reached the stage of formal divorce. The victim's death was likely linked to her husband; consequently, the focus of the investigation should now shift to his personal belongings. Tieu Lau systematically checked every pocket of every garment belonging to the male occupant of the apartment. Ultimately, he discovered only a single wallet.");
        searchableObject photograph = new searchableObject("PHOTOGRAPH", "It contained neither cash nor bank cards - nothing but the couple's joint photograph taken from their marriage certificate. In the photo, the woman wore a pristine white wedding gown, her face beaming with happiness as she nestled against the man; they made for a stunning couple - a handsome man and a beautiful woman, perfectly matched.", 10);

        //searchableObject dressingTable = new searchableObject("DRESSING TABLE", "\"Tieu Lau calmed himself down to think for a moment, then turned his attention to the dressing table and the nightstand. On the dressing table, he discovered a small, exquisite bottle of perfume; upon opening it and taking a whiff, he confirmed that it indeed carried the scent of roses. Inside one of the dressing table drawers, he found a greeting card bearing the inscription: \n\"Dearest friend, this bottle of perfume is a gift for you. Happy Birthday - may you always remain youthful and beautiful. Your very best friend, Luu Van; July 17th.\"\nThe words \"best friend\" on the card had been crossed out with two bold, crimson X marks.");
        searchableObject perfume = new searchableObject("PERFUME", "Tieu Lau calmed himself down to think for a moment, then turned his attention to the dressing table and the nightstand. On the dressing table, he discovered a small, exquisite bottle of perfume; upon opening it and taking a whiff, he confirmed that it indeed carried the scent of roses. Inside one of the dressing table drawers, he found a greeting card bearing the inscription: \n\"Dearest friend, this bottle of perfume is a gift for you. Happy Birthday - may you always remain youthful and beautiful. Your very best friend, Luu Van; July 17th.\"\nThe words \"best friend\" on the card had been crossed out with two bold, crimson X marks.", 25);
        // add objects to main bedroom
        this.listOfCells.get(14).objects.add(wardrobe);
        this.listOfCells.get(14).objects.add(photograph);
        this.listOfCells.get(14).objects.add(perfume);

    
        // kitchen
        searchableObject fruitKnife = new searchableObject("FRUIT KNIFE", "Tieu Lau gently withdrew the knife. The blade was slender and razor-sharp — the wound it would inflict matched the fatal injury on the victim's chest that Tieu Lau had just discovered during the autopsy. This fruit knife was the murder weapon.", 20);
      
        searchableObject trashCanKitchen = new searchableObject("TRASH CAN", "Tieu Lau proceeded to rummage through the kitchen trash can. Inside, he found an abundance of vegetable scraps, fruit peels, eggshells, and packaging from frozen meat. It could be inferred that, prior to their death, the victim had prepared dinner at home—and enough for roughly two people. Comprising both vegetarian and meat dishes, the meal consisted of at least five different items; the victim alone could not possibly have consumed that much food. Amidst the general refuse and fruit peels lay a greeting card, the standard type typically found in florists' shops, bearing the inscription: \"Happy Birthday. Your husband loves you forever.\"", 5);
        // add objects to kitchen
        this.listOfCells.get(22).objects.add(fruitKnife);
        this.listOfCells.get(22).objects.add(trashCanKitchen);


        // office
        searchableObject safe = new searchableObject("SAFE", "The safe had a two-compartment structure; the top compartment held a stack of documents. The top compartment contained Two Insurance Policies, and below it were several photo albums. Tieu Lau continued his search and discovered a file folder tucked away in a hidden corner of the bottom drawer.");

        searchableObject insurance = new searchableObject("INSURANCE POLICIES", "Two insurance policies. The first contract listed Trau Tieu Man as the insured and Trieu Sam as the beneficiary, identifying their relationship as husband and wife. The second contract was the reverse: Trieu Sam was the insured, and Trau Tieu Man was the beneficiary. The couple had purchased commercial insurance policies for one another — covering medical expenses, life insurance, and accidental death — at an annual cost exceeding 10,000 yuan. If the insured party required hospitalization due to serious conditions, such as fibroids, cardiovascular disease, or similar ailments, all hospital expenses would be reimbursed, up to a limit of 500,000 yuan. Furthermore, if the insured were to suffer a sudden, unexpected death, the beneficiary would receive a payout of up to 2 million yuan from the insurance company. The moment Tieu Lau laid eyes on these two contracts, a sudden chill ran through him. He, too, had purchased health insurance for his parents; family members buying insurance for one another was a perfectly normal practice. However, committing murder solely to collect an insurance payout was by no means a rare occurrence; he had once read a news report about a son who killed his own mother just to claim the insurance money - it was sheer madness. In this particular case, the marital bond between husband and wife had already fractured; all it would take was for Trau Tieu Man to meet with an \"unfortunate accident,\" and Trieu Sam would stand to collect a payout of 2 million yuan!", 5);
        searchableObject album = new searchableObject("ALBUM", "He set the insurance policies aside and proceeded to examine the lower compartment of the safe. Inside lay several photo albums. The albums were filled exclusively with photographs of Trieu Sam - spanning his elementary, middle, and high school years, all the way up to his university graduation, clearly documenting his entire journey of growth and maturation. He appeared to suffer from congenital nearsightedness, as he had worn glasses since childhood. Judging solely by these photo albums, Trieu Sam would seem to be a gentle, approachable individual; in every single photograph, he wore a smile. Aside from this personal album, there was also a wedding album. In the early days of their marriage, the couple was incredibly affectionate; the husband tenderly embraced his wife, while she leaned gently against his chest - even their smiles were imbued with happiness. Turning the pages, Tieu Lau came across photographs taken at the wedding reception. Among them was a picture featuring four people: the bride and groom, along with the best man and the maid of honor. This group shot appeared to have been taken from an oblique angle, as none of the four individuals were looking directly at the camera. In the image, the bride and groom were gazing at one another with smiles; the maid of honor was looking affectionately at the best man; yet the best man - standing just a short distance away as he raised his glass for a toast - could not tear his eyes away from the bride. Tieu Lau's senses went on high alert! The fourth person implicated in this case had finally appeared! This best man had also made an appearance in Trieu Sam's personal album; specifically, within the section dedicated to Trieu Sam's graduation photos, there was a picture of the two men standing with their arms draped over each other's shoulders. Their relationship must have been extremely close - so close, in fact, that Trieu Sam had invited him to serve as his best man the moment he got married.", 10);
        searchableObject detectiveFolder = new searchableObject("HIDDEN FOLDER", "Upon opening it, he found another contract inside - this one an investigative agreement between Trieu Sam and a private detective. The investigation focused on the relationships among three individuals: the cousin, Ha Vinh Cuong; the wife, Trau Tieu Man; and the wife's close friend, Luu Van. As Tieu Lau pulled the contract out, a stack of photographs tumbled down. He picked up the photos; they depicted the three of them shopping, dining out, and strolling through the streets together. Several shots showed Luu Van and Ha Vinh Cuong holding hands intimately, while others captured Ha Vinh Cuong and Trau Tieu Man embracing tenderly. That bastard Ha Vinh Cuong was truly playing both sides—carrying on a romance with the young and beautiful Luu Van on one hand, while committing adultery with his sister-in-law on the other. The photos toward the end were even more scandalous; they showed Chau Tieu Man - clad in sheer, seductive silk lingerie - getting intimate with Ha Vinh Cuong inside the bedroom. The indoor shots appeared to have been taken from a high angle, with a timestamp visible in the top-right corner. It was clear that, by this time, Trieu Sam had already installed surveillance cameras within the home to monitor his wife's movements, and these images were the direct result of that surveillance.",5);
        // add objects to office
        this.listOfCells.get(30).objects.add(safe);
        this.listOfCells.get(30).objects.add(insurance);
        this.listOfCells.get(30).objects.add(album);
        this.listOfCells.get(30).objects.add(detectiveFolder);


        // children's room
        searchableObject phone = new searchableObject("PHONE", "To see the phone's information, please enter the command \"search phone\"", 10);
        // add phone to children's room
        this.listOfCells.get(46).objects.add(phone);

    }
}