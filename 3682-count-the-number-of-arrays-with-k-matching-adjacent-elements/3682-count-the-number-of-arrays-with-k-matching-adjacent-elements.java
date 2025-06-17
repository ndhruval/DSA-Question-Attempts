class Solution {
    final int MOD = 1000000007;

    public int countGoodArrays(int n, int m, int k) {
        // Compute x = m * (m - 1)^(n - k - 1) % MOD
        long x = modPow(m - 1, n - k - 1, MOD);
        x = (x * m) % MOD;

        // Compute C(n-1, k) % MOD
        long comb = nCrMod(n - 1, k, MOD);

        // Final answer
        return (int)((x * comb) % MOD);
    }

    // Fast modular exponentiation
    private long modPow(long base, int exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1)
                result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    // Computes nCr % mod using precomputed factorials
    private long nCrMod(int n, int r, int mod) {
        if (r < 0 || r > n) return 0;
        long[] fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % mod;
        }
        long denom = (fact[r] * fact[n - r]) % mod;
        return (fact[n] * modInverse(denom, mod)) % mod;
    }

    // Modular inverse using Fermat's theorem
    private long modInverse(long a, int mod) {
        return modPow(a, mod - 2, mod);
    }
}
