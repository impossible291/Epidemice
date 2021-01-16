

public class Test {
    public static void main(String[] args) {
        int a[][]={{1,3},{2,2},{3,1}};
        int truchSize=4;
        maximumUnits(a,truchSize);
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        int max=0;
        int count=0;
        int temp=0;
        for(int i=0;i<boxTypes.length;i++){
            for(int j=1;j<boxTypes[0].length;j++){
                int n=boxTypes[i][0]*boxTypes[i][1];
                temp+=n;
                System.out.println(n);
                if(temp>max){
                    max=temp;
                }
                count+=boxTypes[i][0];
                if(count<truckSize && count<boxTypes[i][0]){
                    max=max+(truckSize-count)*boxTypes[i][1];
                    break;
                }else{
                    break;
                }
            }
        }
        return max;

    }

}
