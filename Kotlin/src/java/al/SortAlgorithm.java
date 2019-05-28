package al;

public class SortAlgorithm {
    public static void main(String [] args){
        System.out.println("Hello,world!");
        SortAlgorithm sortAlgorithm=new SortAlgorithm();
        int[] ar={9,3,1,6,4,5,7,8,2};
        sortAlgorithm.sort(ar);
        for(int a:ar){
            System.out.print(a+" ");
        }

    }
    public static void sort(int[] a){
        //
        // StdRandom.shuffle(a);//将数组a顺序打乱，消除对输入的依赖，这是《算法第四版》作者写好的静态函数
        sort(a,0,a.length-1);
    }
    private static void sort(int[] a, int lo, int hi){
        if(hi<=lo) return;
        int j=partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);

    }
    private static int partition(int[] a,int lo,int hi){
        int i=lo,j=hi+1;
        int v=a[lo];
        while (true){
            while(less(a[++i],v))if(i==hi)break;
            while(less(v,a[--j]))if(j==lo)break;
            if(i>=j)break;
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }
    private static void exch(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    private static Boolean less(int i,int j){
        if(i<j)return true;
        return false;
    }
}
