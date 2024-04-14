import java.util.Scanner;

public class Subnetting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter IP address: ");
        String ipAddress = scanner.nextLine();
        System.out.print("Enter subnet prefix length: ");
        int prefixLength = scanner.nextInt();
        
        String subnetMask = calculateSubnetMask(prefixLength);
        System.out.println("Subnet Mask: " + subnetMask);
        
        String networkAddress = calculateNetworkAddress(ipAddress, subnetMask);
        System.out.println("Network Address: " + networkAddress);
        
        String broadcastAddress = calculateBroadcastAddress(ipAddress, subnetMask);
        System.out.println("Broadcast Address: " + broadcastAddress);
    }
    
    public static String calculateSubnetMask(int prefixLength) {
        int fullBytes = prefixLength / 8; // Number of full bytes in the prefix
        int remainingBits = prefixLength % 8; // Number of remaining bits in the prefix
        
        int[] subnetMaskBytes = new int[4];
        
        // Calculate full bytes
        for (int i = 0; i < fullBytes; i++) {
            subnetMaskBytes[i] = 255; // Each full byte is 255
        }
        
        // Calculate remaining bits
        if (remainingBits > 0) {
            int Lastbyte=(int) (Math.pow(2,remainingBits)-1);
      
            subnetMaskBytes[fullBytes] = lastByte << (8 - remainingBits);
        }
        
        // Build the subnet mask string
        StringBuilder subnetMaskBuilder = new StringBuilder();
        for (int i = 0; i < subnetMaskBytes.length; i++) {
            subnetMaskBuilder.append(subnetMaskBytes[i]);
            if (i < subnetMaskBytes.length - 1) {
                subnetMaskBuilder.append(".");
            }
        }
        
        return subnetMaskBuilder.toString();
    }
    
    public static String calculateNetworkAddress(String ipAddress, String subnetMask) {
        String[] ipOctets = ipAddress.split("\\.");
        String[] maskOctets = subnetMask.split("\\.");
        
        StringBuilder networkAddressBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int ipOctet = Integer.parseInt(ipOctets[i]);
            int maskOctet = Integer.parseInt(maskOctets[i]);
            int networkOctet = ipOctet & maskOctet;
            
            networkAddressBuilder.append(networkOctet);
            if (i < 3) {
                networkAddressBuilder.append(".");
            }
        }
        
        return networkAddressBuilder.toString();
    }
    
    public static String calculateBroadcastAddress(String ipAddress, String subnetMask) {
        String[] ipOctets = ipAddress.split("\\.");
        String[] maskOctets = subnetMask.split("\\.");
        
        StringBuilder broadcastAddressBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int ipOctet = Integer.parseInt(ipOctets[i]);
            int maskOctet = Integer.parseInt(maskOctets[i]);
            int broadcastOctet = ipOctet | (maskOctet ^ 255);
            
            broadcastAddressBuilder.append(broadcastOctet);
            if (i < 3) {
                broadcastAddressBuilder.append(".");
            }
        }
        
        return broadcastAddressBuilder.toString();
    }
}