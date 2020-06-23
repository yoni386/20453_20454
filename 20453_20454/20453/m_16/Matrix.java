/**
 * Represents information about a Matrix Maman16 question1.
 *
 * @author (Yoni Shperling)
 * @version (10.01.19)
 */
public class Matrix
{
    // instance variables
    private int[][] _array;

    // declarations of constants and variables
    private final static int ZERO = 0;
    private final static int ONE = 1;

    /**
     * Constructs a Matrix from a two-dimensional array; the dimensions as well as the
     * values of this Matrix will be the same as the dimensions and values of the two-dimensional array.
     */
    public Matrix(int[][] array)
    {
        // initialise instance variables
        _array = new int[array.length][]; // new array with length (rows) of arrayRowsLength. At this point, Columns are not set only the elements in array

        // array.length rows => how many elements are in the array
        // arrayColumnsLength declared in for loop => // columns per array (element of the elements) how many elements in the "nested array" array[i].length

        for (int i = 0; i < array.length; i++) // setting the only calling new and allocating the correct size as given in the formal parameter
        {
            // array[i].length is length Columns per row columns per array (element of the elements) how many elements in the "nested array"
            _array[i] = new int[array[i].length]; // set new array inside the _array at _array[i] (row: index i) with length of arrayColumnsLength
        }

        for (int i = 0; i < array.length; i++) // iterate all elements (all arrays of the array) of array set the elments as in the orginal array (array is passed by formal parameter)
        { 
            for (int j = 0; j < array[i].length; j++) // iterate all elements all int's of the array 
            {
                _array[i][j] = array[i][j]; // set the elments of the new Matrix as in the orginal array
            }
        }
    }

    /**
     * Constructs a size1 by size2 Matrix of zeroes.
     */
    public Matrix(int size1, int size2)
    {
        _array = new int[size1][size2]; // new array with length (rows) of size1 and columns are as length of size2 (size1 and size2 are from the formal parameter and are positive - according in the mman)
    }

    /**
     * Method toString - String representation of the object.
     * 
     * A element in the array, is by it self an array. Each element (array in the array) is separated by a new line (\n) => this reperestns one line vertical array
     * Elements of the array (element of the elements) must be separated by a tab (\t) => this represents one line the horizontal array
     * Returns a string representation of this Matrux ("textually represents") in the format:
     * if Matrix is 3*3 e.g. :
     * 3    8   72
     * 4    6   60
     * 253  2   1
     * String will be "3\t8\t72\n4\t6\t60\n253\t2\t1\n"
     * 
     * @return String representation of the object.
     */
    public String toString()
    {
        String matrixString = new String(); // Initializes a newly created String object represents an empty character sequence

        for (int i = 0; i < _array.length; i++) // set the elments of each row (first array) and column (second array)
        {
            for (int j = 0; j < _array[i].length; j++)
            {
                matrixString += "" + _array[i][j]; // cast int to string 3 => "3"

                if ( j < (_array[i].length - ONE) ) // \t only if elments are not the last elment in the array. If true, \t will added to the string. false on the last elment and then \t is not required.
                {
                    matrixString += "\t";
                }
            }

            matrixString += "\n"; // \n new line at the end of iteration 
        }

        return matrixString;
    }

    /**
     * Method flipVertical - make the image on which the method was applied around the horizontal axis. 
     * The first line becomes the last line, the second becomes the second from the end and etc.
     *
     * @return new Matrix object with new values. The new values (image) are applied around the horizontal axis of the Matrix that was called from it. 
     */
    public Matrix flipVertical()
    {
        Matrix newMatrix = new Matrix(_array); // calling contractor new Matrix instance is created. At this point all values are copied

        // newMatrix.resetArray(); // this comment out as ChenU suggested redundant due to the following overwrite. reset array => zeroing all elments in the array. This can be skipped 

        final int rowOffset = (_array.length - ONE); // if 3*3 then length-1 => 2 (0-2)

        for (int lastArrayRowIndex = rowOffset, rowIndex = 0; lastArrayRowIndex >= ZERO; lastArrayRowIndex--, rowIndex++) //  lastArrayRowIndex = rowOffset lastArrayRow. set the elments of each row (first array) and column (second array)
        { 
            for (int columnIndex = 0; columnIndex < _array[lastArrayRowIndex].length; columnIndex++)
            {         
                newMatrix._array[rowIndex][columnIndex] = _array[lastArrayRowIndex][columnIndex];
            }
        }

        return newMatrix;  
    }

    /**
     * Method flipHorizontal - make the image on which the method was applied around the vertical axis. 
     * The first line becomes the last line, the second becomes the second from the end and etc.
     *
     * @return new Matrix object with new values. The new values (image) are applied around the vertical axis of the Matrix that was called from it. 
     */
    public Matrix flipHorizontal()
    {
        Matrix newMatrix = new Matrix(_array); // calling contractor new Matrix instance is created. At this point all values are copied

        // newMatrix.resetArray(); // reset array => zeroing all elments in the array // this comment out as ChenU suggested redundant due to the following overwrite.

        for (int rowIndex = 0; rowIndex < _array.length; rowIndex++) // lastArrayRowIndex = rowOffset lastArrayRow. Set the elments of each row (first array) and column (second array)
        {
            for (int copyFromColumnIdx = (_array[rowIndex].length - ONE), copyToColumnIdx = 0; copyFromColumnIdx >= ZERO; copyFromColumnIdx--, copyToColumnIdx++)
            {        
                newMatrix._array[rowIndex][copyToColumnIdx] = _array[rowIndex][copyFromColumnIdx]; // copyToColumnIdx is the index used copy into and copyFromColumnIdx is the index to copy from
            }
        }

        return newMatrix;  
    }

    /**
     * Method rotateClockwise - Rotates the image 90 degrees clockwise. 
     * This method can change the dimensions of the image, meaning can change the size (length) of the array => number elements can and will be adjusted to the new size.
     *
     * @return new Matrix object with new values. The new values (image) are applied rotated by 90 degrees clockwise relative to the Matrix that was called from it. 
     */
    public Matrix rotateClockwise()
    {
        final int ColumnsSize = getMaxColumnsLength(_array); // size2, in this context it used as size1

        Matrix newMatrix = new Matrix(ColumnsSize, _array.length); // calling contractor new Matrix instance is created. At this point all values are zeroes

        for (int i = 0, rowOffset = (_array.length - ONE); i < newMatrix._array.length; i++)
        {
            // rowOffset declared in the loop => (_array.length - ONE); // if 3*3 then length-1 => 2 (0-2)
            for (int j = 0, z = rowOffset; ( ( j < newMatrix._array[i].length ) && (z >= ZERO) ); j++, z--) // z is referance to rowOffset, offset is the last element and it decrements each iteration e.g. 4..3..0
            {
                newMatrix._array[i][j] = _array[z][i];
            }
        }

        return newMatrix;  
    }

    /**
     * Method rotateCounterClockwise - Rotates the image 90 degrees counterclockwise. 
     * This method can change the dimensions of the image, meaning can change the size (length) of the array => number elements can and will be adjusted to the new size.
     *
     * @return new Matrix object with new values. The new values (image) are applied rotated by 90 degrees counterclockwise relative to the Matrix that was called from it. 
     */
    public Matrix rotateCounterClockwise()
    {
        final int ColumnsSize = getMaxColumnsLength(_array); // size2, in this context it used as size1

        Matrix newMatrix = new Matrix(ColumnsSize, _array.length); // calling contractor new Matrix instance is created. At this point all values are zeroes

        final int columnOffset = (ColumnsSize - ONE); // if 4*5 then ColumnsSize-1 => 4 (0-3)

        for (int i = 0, z = columnOffset; (i < newMatrix._array.length) && (z >= ZERO); i++, z--) // z is referance to rowOffset, offset is the last element and it decrements each iteration e.g. 4..3..0
        {
            for (int j = 0; (j < newMatrix._array[i].length); j++)
            {
                newMatrix._array[i][j] = _array[j][z];
            }
        }

        return newMatrix;  
    }

    private static int getMaxColumnsLength(int[][] array) // reterive the maximum ColumnsLength (highest) on each row ([][] array nested elements) 
    {
        int columnsMaxLength = ZERO; // this is used to hold the maximum size of columns length

        for (int i = 0; i < array.length; i++) // set the elments of each row (first array) and column (second array). Iterate all elements and updates the maximum size (length)
        { 
            if (columnsMaxLength < array[i].length) // if true, columnsMaxLength is set array[i].length (columnsMaxLength = array[i].length) => max length is returned
            {
                columnsMaxLength = array[i].length;
            }
        }

        return columnsMaxLength;
    }

    private void resetArray()
    {
        for (int i = 0; i < _array.length; i++) // set the elments of each row (first array) and column (second array)
        { 
            for (int j = 0; j < _array[i].length; j++)
            {
                _array[i][j] = ZERO;
            }
        }
    }
}
