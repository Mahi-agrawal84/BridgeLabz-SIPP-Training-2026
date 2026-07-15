class MathWizard {

    // Instance variable
    instanceVar = 100;

    // Check if a number is prime
    isPrime(n) {
        if (typeof n !== 'number' || n <= 1) return false;

        for (let i = 2; i <= Math.sqrt(n); i++) {
            if (n % i === 0) return false;
        }
        return true;
    }

    // Factorial (only non-negative integers)
    factorial(n) {
        if (typeof n !== 'number' || n < 0 || n % 1 !== 0) {
            console.log('Factorial is defined only for non-negative integers.');
            return -1;
        }

        let fact = 1;
        for (let i = 1; i <= n; i++) fact *= i;
        return fact;
    }

    // Fibonacci series up to n terms
    fibonacci(n) {
        let a = 0, b = 1;
        const out = [];
        for (let i = 0; i < n; i++) {
            out.push(a);
            const next = a + b;
            a = b;
            b = next;
        }
        console.log('Fibonacci Series:', out.join(' '));
    }

    // GCD using Euclidean Algorithm
    gcd(a, b) {
        a = Math.abs(a); b = Math.abs(b);
        while (b !== 0) {
            const temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // LCM
    lcm(a, b) {
        if (a === 0 || b === 0) return 0;
        return Math.abs((a * b) / this.gcd(a, b));
    }

    // Power function
    power(base, exp) {
        let result = 1;
        for (let i = 1; i <= exp; i++) result *= base;
        return result;
    }

    // Demonstrating local vs instance variable scope
    showScope() {
        const instanceVar = 50; // Local variable
        console.log('Local Variable =', instanceVar);
        console.log('Instance Variable =', this.instanceVar);
    }
}

// Main execution
const mw = new MathWizard();

console.log('Is 17 Prime?', mw.isPrime(17));
console.log('Factorial of 5 =', mw.factorial(5));
console.log('Factorial of 6.0 =', mw.factorial(6.0));
mw.fibonacci(10);
console.log('GCD of 24 and 36 =', mw.gcd(24, 36));
console.log('LCM of 24 and 36 =', mw.lcm(24, 36));
console.log('2^5 =', mw.power(2, 5));
console.log('\nScope Demonstration:');
mw.showScope();