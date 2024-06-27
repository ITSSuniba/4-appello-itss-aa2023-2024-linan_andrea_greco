import org.example.Mediana;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
//-------------------------------------HOMEWORK 1-------------------------------------------------------
public class MedianaTest {


    Mediana m = new Mediana();

    @Test
    @DisplayName("T1 - entrambi gli array vuoti")
    public void testMethodWithTwoArrayEmpty(){
        int [] arrayVuoto1 = {}; //produce bug
        int [] arrayVuoto2 = {};
        assertEquals(0,m.findMedianSortedArrays(arrayVuoto1,arrayVuoto2));
    }

    @Test
    @DisplayName("T2 - array1 vuoto, array2 dimensione >0")
    public void testMethodArrayEmptyandArrayHaveSize(){
        int [] array1 = {};
        int [] array2 = {1,2,3};
        assertEquals(2,m.findMedianSortedArrays(array1,array2));
    }

    @Test
    @DisplayName("T4 array1 dimensione >0, array2 vuoto")
    public void testMethodArrayHaveSizeArrayEmpty(){
        int [] array2 = {};
        int [] array1 = {1,2,3};
        assertEquals(2,m.findMedianSortedArrays(array1,array2));
    }

    @Test
    @DisplayName("T5 Entrambi gli array contengono lo stesso valore ripetuto")
    public void testT5(){
        int [] array1 = {1,3,3};
        int [] array2 = {2,3,3};
        assertEquals(3,m.findMedianSortedArrays(array1,array2));
    }


    @Test
    @DisplayName("T6.1 entrambi gli array contengono un solo elemento")
    public void testT6(){
        int [] array1 = {1};
        int [] array2 = {1};
        assertEquals(1,m.findMedianSortedArrays(array1,array2));
    }

    @Test
    @DisplayName("T6.2 entrambi gli array contengono un solo elemento")
    public void testT6_2(){
        int [] array1 = {Integer.MIN_VALUE};
        int [] array2 = {Integer.MIN_VALUE};
        double result = (array1[0] + array2[0])/2;
        assertEquals(result,m.findMedianSortedArrays(array1,array2));
    }

    @Test
    @DisplayName("T6.3 entrambi gli array contengono un solo elemento")
    public void testT6_3(){
        int [] array1 = {Integer.MAX_VALUE};
        int [] array2 = {Integer.MAX_VALUE};
        double result = (array1[0] + array2[0])/2;
        assertEquals(result,m.findMedianSortedArrays(array1,array2));
    }


    @Test
    //@Disabled
    @DisplayName("T7 array1 di dimensione pari, array2 di dimensione dispari")
    public void testMethodArrayDispariArrayPari(){
        int [] array1pari = {1,2};
        int [] array2Dispari = {2,4,3};
        assertEquals(2,m.findMedianSortedArrays(array1pari,array2Dispari));
    }

    @Test
    @DisplayName("T8 array1 di dimensione dispari, array2 di dimensione dispari")
    public void testMethodArrayPariArrayDispari(){
        int [] array1 = {1,1,2};
        int [] array2 = {1,2,5};
        assertEquals(1.5,m.findMedianSortedArrays(array1,array2));
    }

    @Test
    @DisplayName("T9 array1 di dimensione pari, array2 di dimensione pari")
    public void testT9(){
        int [] array1 = {1,1,2,6};
        int [] array2 = {1,2,4,5};
        assertEquals(2,m.findMedianSortedArrays(array1,array2));
    }


    @Test
    @DisplayName("T10 Array1 e array2 non vuoti e in ordine decrescente")
    public void testMethodVuotiDecrescente(){
        int [] array1 = {9,7,5,3,1};
        int [] array2 = {8,6,4,2,0};
        assertEquals(4.5,m.findMedianSortedArrays(array1,array2));
    }

    @Test
    @DisplayName("T11 stessi elementi e dimensioni")
    public void testMethodEqualElementAndSize(){
        int [] array1 = {2,2,2};
        int [] array2 = {2,2,2};
        assertEquals(2,m.findMedianSortedArrays(array1,array2));
    }

    @Test
    @DisplayName("T12.1 array1 è un sottoinsieme dell’array2 caso pari")
    public void testMethodSottoinsiemeCasoPari(){
        int [] array1 = {2,3};
        int [] array2 = {1,2,3,4,5,6};
        assertEquals(3,m.findMedianSortedArrays(array1,array2));
    }

    @Test
    @DisplayName("T12.2 array1 è un sottoinsieme dell’array2 caso dispari")
    public void testMethodSottoinsiemeCasoDispari(){
        int [] array1 = {3,4};
        int [] array2 = {1,2,3,4,5};
        assertEquals(3,m.findMedianSortedArrays(array1,array2));
    }

    @Test
    @DisplayName("T13.1 array1 valori identici array2 vuoto")
    public void testMethodIdenticiVuoto(){
        int [] array1 = {6,6,6,6,6};
        int [] array2 = {};
        assertEquals(6,m.findMedianSortedArrays(array1,array2));
    }

    @Test
    @DisplayName("T13.2 array1 vuoto array2 valori identici") 
    public void testMethodVuotoIdentici(){
        int [] array1 = {};
        int [] array2 = {6,6,6,6,6,6};
        assertEquals(6,m.findMedianSortedArrays(array1,array2));
    }

}
