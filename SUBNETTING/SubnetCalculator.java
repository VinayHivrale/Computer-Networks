import java.util.Scanner;

  public class SubnetCalculator {

  public static void main(String[] args) {

  Scanner scanner = new Scanner(System.in);

  System.out.print("Enter IPaddress: ");
  String ipAddress = scanner.nextLine();

  System.out.print("Enter subnet prefix length: ");
  int prefixLength = scanner.nextInt();

  String subnetMask = calculateSubnetMask(prefixLength);
  System.out.println("Subnet Mask:" + subnetMask);

 }

 public static String calculateSubnetMask(int prefixLength) {

        int fullBytes = prefixLength / 8;  // Number of full bytes in the prefix


        int remainingBits = prefixLength %8;  
        // Number of remaining bits in theprefix
        int[] subnetMaskBytes = new int[4];

        // Calculate full bytes
        for (int i = 0; i < fullBytes; i++)
        subnetMaskBytes[i] = 255;  // Each full byte is 255

        // Calculate remaining bits
        if (remainingBits > 0) {

        int lastByte = (int) (Math.pow(2,remainingBits) - 1);
         subnetMaskBytes[fullBytes] =lastByte << (8 - remainingBits);

 }
        // Build the subnet mask string

         StringBuilder subnetMaskBuilder = new StringBuilder();

         for (int i = 0; i <subnetMaskBytes.length; i++) {
         subnetMaskBuilder.append(subnetMaskBytes[i]);
         if (i < subnetMaskBytes.length -1) 
            subnetMaskBuilder.append(".");
}

 return subnetMaskBuilder.toString();


    }


}