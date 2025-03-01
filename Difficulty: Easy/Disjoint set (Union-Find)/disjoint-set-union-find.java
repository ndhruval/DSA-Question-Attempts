//{ Driver Code Starts
import java.util.*;

class Disjoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++) a[i] = i;
            int k = sc.nextInt();
            GfG g = new GfG();
            for (int i = 0; i < k; i++) {
                String s = sc.next();
                if (s.equals("UNION")) {
                    int x = sc.nextInt();
                    int z = sc.nextInt();
                    g.unionSet(a, x, z);
                } else {
                    int x = sc.nextInt();
                    int parent = g.find(a, x);
                    System.out.print(parent + " ");
                }
            }
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class GfG {
    // find method recursively finds the root parent of x in the array par
    int find(int par[], int x) {
        // if par[x] is the root parent of x, return par[x]
        // otherwise, recursively call find on par[par[x]]
        return par[par[x]] == par[x] ? par[x] : find(par, par[x]);
    }

    // unionSet method connects the set containing x with the set containing z
    void unionSet(int par[], int x, int z) {
        // find the root parent of x and z, and set their parent to be the same in the
        // array par
        par[find(par, x)] = find(par, z);
    }
}