
// File Header
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Chugimon.java
// Course:   CS 300 Fall 2022
//
// Author:   Aaryaman Singh
// Email:    singh283@wisc.edu
// Lecturer: Mouna Kacem
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Vardaan Kapoor
// Partner Email:   vkapoor5@wisc.edu
// Partner Lecturer's Name: Hobbes
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   __X_ Write-up states that pair programming is allowed for this assignment.
//   _X__ We have both read and understand the course Pair Programming Policy.
//   __X_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         N/A
// Online Sources:  N/A
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class models a Chugimon
 */
public class Chugimon implements Comparable<Chugimon>
{
    private final int FIRST_ID;  //The first ID of the Chugimon
    private final double HEIGHT; // The height of the Chugimon in meters
    static final int MIN_ID = ChugidexUtility.MIN_CHUGI_ID;; // The minimum ID number
    static final int MAX_ID = ChugidexUtility.MAX_CHUGI_ID;;  // The maximum ID number
    private final String NAME; // The name of the Chugimon
    private final int SECOND_ID; // The second ID of the Chugimon
    private final ChugiType PRIMARY_TYPE;  // The primary type of the Chugimon; cannot be null; cannot be the same as the secondary type
    private final ChugiType SECONDARY_TYPE; // The secondary type of the Chugimon; may be null; cannot be the same as the primary type
    private final double WEIGHT; // The weight of the Chugimon in kilograms

    /**
     * Creates a new Chugimon with specific first and second IDs and initializes all its data fields accordingly.
     *
     * @param firstID - The first ID of the Chugimon, between 1-151
     * @param secondID - the second ID of the Chugimon, between 1-151
     */
    public Chugimon(int firstID, int secondID) throws IllegalArgumentException
    {
        FIRST_ID = firstID;
        SECOND_ID = secondID;
        HEIGHT = ChugidexUtility.getChugimonHeight(FIRST_ID, SECOND_ID);
        NAME = ChugidexUtility.getChugimonName(FIRST_ID, SECOND_ID);
        WEIGHT = ChugidexUtility.getChugimonWeight(FIRST_ID, SECOND_ID);
        ChugiType[] chugi = ChugidexUtility.getChugimonTypes(FIRST_ID, SECOND_ID);
        PRIMARY_TYPE = chugi[0];
        SECONDARY_TYPE = chugi[1];
        if(FIRST_ID < 1 || FIRST_ID > 151 || SECOND_ID < 1 || SECOND_ID > 151 || FIRST_ID == SECOND_ID)
        {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Gets the name of this Chugimon
     * @return - the name of the Chugimon
     */
    public String getName()
    {
        return NAME;
    }

    /**
     * Gets the first ID of this Chugimon
     * @return - the first ID of the Chugimon
     */
    public int getFIRST_ID() {
        return FIRST_ID;
    }

    /**
     * Gets the height of this Chugimon
     * @return - the height of the Chugimon
     */
    public double getHEIGHT() {
        return HEIGHT;
    }

    /**
     * Gets the second ID of thid Chugimon
     * @return - the second ID of the Chugimon
     */
    public int getSECOND_ID() {
        return SECOND_ID;
    }

    /**
     * Gets the primary type of this Chugimon
     * @return - the primary type of the Chugimon
     */
    public ChugiType getPrimaryType() {
        return PRIMARY_TYPE;
    }

    /**
     * Gets the secondary type of this Chugimon
     * @return - the secondary type of the Chugimon
     */
    public ChugiType getSecondaryType() {
        return SECONDARY_TYPE;
    }

    /**
     * Gets the  weight of the Chugimon.
     * @return - the weight of the Chugimon.
     */
    public double getWEIGHT() {
        return WEIGHT;
    }

    /**
     * A Chugimon's String representation is its name followed by "#FIRST_ID.SECOND_ID" -- Example: "Zapchu#145.25"
     * @return - a String representation of this Chugimon
     */
    @Override
    public String toString()
    {
        return NAME + "#" + FIRST_ID + "." + SECOND_ID;
    }

    /**
     * Equals method for Chugimon. This Chugimon equals another object if other is a Chugimon with the exact same name, and their both first and second IDs match.
     * @param other - Object to determine equality against this Chugimon
     * @return - true if this Chugimon and other Object are equal, false otherwise
     */
    @Override
    public boolean equals(Object other)
    {
        if(other instanceof Chugimon && compareTo((Chugimon) other) == 0)
        {
            return true;
        }
        return false;
    }


    /**
     * Determines the ordering of Chugimon. Chugimon are ordered by: 1) name (alphabetical) 2) the first ID (if name is equal). The one with the smaller first ID is less than the other. 3) the second ID (if name and first ID are equal). The one with the smaller second ID is less than the other. A Chugimon with identical #1-3 are considered equal.
     * @param otherChugi - the other Chugimon to compare this Chugimon to.
     * @return - a negative int if this Chugimon is less than other, a positive int if this Chugimon is greater than other, or 0 if this and the other Chugimon are equal.
     */
    @Override
    public int compareTo(Chugimon otherChugi)
    {
//


//        if(this.name.compareTo(o.getName()) == 0 || this.FIRST_ID == o.getFIRST_ID() || this.SECOND_ID == o.getSECOND_ID())
//        {
//            return 1;
        //        }

        if(otherChugi == null)
        {
            return -1;
        }

        if(this.NAME.compareTo(otherChugi.getName()) < 0)
        {
            return -1;
        }
        if(this.NAME.compareTo(otherChugi.getName()) == 0 && this.FIRST_ID < otherChugi.getFIRST_ID())
        {
            return -1;
        }
        if((this.NAME.compareTo(otherChugi.getName()) == 0 && this.FIRST_ID == otherChugi.getFIRST_ID() && this.SECOND_ID < otherChugi.getSECOND_ID()))
        {
            return -1;
        }

        if(this.NAME.compareTo(otherChugi.getName()) > 0)
        {
            return 1;
        }
        if(this.NAME.compareTo(otherChugi.getName()) == 0 && this.FIRST_ID > otherChugi.getFIRST_ID())
        {
            return 1;
        }
        if((this.NAME.compareTo(otherChugi.getName()) == 0 && this.FIRST_ID == otherChugi.getFIRST_ID() && this.SECOND_ID > otherChugi.getSECOND_ID()))
        {
            return 1;
        }
        return 0;

    }
}