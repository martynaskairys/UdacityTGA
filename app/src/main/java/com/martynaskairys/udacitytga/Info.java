package com.martynaskairys.udacitytga;

/**
 * Created by martynaskairys on 07/06/2017.
 */

public class Info {

    /** String resource ID for the default translation of the word */
    private int mToDoDescription;

    /** String resource ID for the Miwok translation of the word */
    private int mToDoName;


    /** Image resource ID for the word */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Word object.
     *
     * @param toDoDescription is the string resource ID for the word in a language that the
     *                             user is already familiar with (such as English)
     * @param toDoName is the string resource Id for the word in the Miwok language
     */
    public Info(int toDoName, int toDoDescription ) {
        mToDoName = toDoName;
        mToDoDescription = toDoDescription;
    }

    /**
     * Create a new Word object.
     *
     * @param toDoDescription is the string resource ID for the word in a language that the
     *                             user is already familiar with (such as English)
     * @param toDoName is the string resource Id for the word in the Miwok language
     * @param imageResourceId is the drawable resource ID for the image associated with the word
     */
    public Info(int toDoName,int toDoDescription,  int imageResourceId
                ) {
        mToDoName = toDoName;
        mToDoDescription = toDoDescription;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the string resource ID for the default translation of the word.
     */
    public int getDefaultDescription() {
        return mToDoDescription;
    }

    /**
     * Get the string resource ID for the Miwok translation of the word.
     */
    public int getToDoNameDescription() {
        return mToDoName;
    }

    /**
     * Return the image resource ID of the word.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }


}
