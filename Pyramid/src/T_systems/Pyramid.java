package T_systems;

import java.util.*;

class PyramidBuilder {

    public int[][] buildPyramid(List<Integer> inputNumbers) {
        // TODO : Implement your solution here
        try {
            Collections.sort(inputNumbers);
        } catch (OutOfMemoryError ex) {
            throw new CannotBuildPyramidException();
        } catch (NullPointerException e) {
            throw new CannotBuildPyramidException();
        }
        int[][] pyramid = null;
        int dimensionPyramid = 0;
        int countElements = 0;
        for (int i = 1; countElements < inputNumbers.size(); i++){
            countElements = countElements + i;
            dimensionPyramid++;
        }
        if (countElements != inputNumbers.size()) {
            throw new CannotBuildPyramidException();
        }
        else {
            //System.out.println("dimension " + dimensionPyramid);
            //System.out.println("countColumns " + (dimensionPyramid * 2 - 1));
            int countColumns = dimensionPyramid * 2 -1;
            pyramid = new int[dimensionPyramid][countColumns];
            for (int i = 0; i < dimensionPyramid; i++) {
                for (int j = 0; j < countColumns; j++) {
                    pyramid[i][j] = 0;
                }
            }

            int placeInRow = dimensionPyramid - 1;
            int countElementsInRow = 1;
            int listInd = 0;
            for (int i = 0; i < dimensionPyramid; i++) {
                for (int j = 0; j < countElementsInRow; j++) {
                    pyramid[i][placeInRow] = inputNumbers.get(listInd);
                    listInd++;
                    placeInRow = placeInRow + 2;
                }
                countElementsInRow++;
                placeInRow = dimensionPyramid - countElementsInRow;
            }
        }
        for(int r=0; r<pyramid.length; r++) {
            for(int c=0; c<pyramid[r].length; c++)
                System.out.print(pyramid[r][c] + " ");
            System.out.println();
        }
        return pyramid;
    }

    public static void main(String[] args) {
        PyramidBuilder op = new PyramidBuilder();
        List<Integer> intList = Arrays.asList(11, 1, 21, 12, 3, 16, 2, 13, 9, 4, 17, 5, 14, 10, 18, 8, 7, 19, 15, 6, 20);
        op.buildPyramid(intList);


    }

}