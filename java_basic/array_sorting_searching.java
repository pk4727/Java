interface arraymethod 
{
    void sort(int[] arr);
    boolean search(int[] arr, int key);
}
class array_sorting_searching implements arraymethod
{
    public void sort(int[] arr) 
    {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) 
        {
            for (int j = 0; j < arr.length - 1 - i; j++) 
            {
                if (arr[j] > arr[j + 1]) 
                {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("\nThe sorted Array : \n");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i] + "\t");
        }
    }

    public boolean search(int[] arr, int key) 
    {
        for (int i = 0; i < arr.length; i++) 
        {
            if (arr[i] == key) 
            {
                return true;
            }
        }
        return false;
    }
}
class arrayy
{
    public static void main(String[] args) 
    {
        int[] arr = { 1, 5, 8, 2, 4 };
        array_sorting_searching a = new array_sorting_searching();
        a.sort(arr);
        boolean found = a.search(arr, 5);
        if (found) 
        {
            System.out.println("\nSearch found!!");
        } 
        else 
        {
            System.out.println("\nSearch not found !!");
        }
    }
}