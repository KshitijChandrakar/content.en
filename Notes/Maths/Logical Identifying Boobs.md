Logical identities (also known as **laws of logic**) are standard equivalences or rules that hold in propositional logic. These can be used to simplify logical expressions or prove statements like tautologies. Below are some of the most commonly used logical identities, categorized by type:

### 1. **Basic Identities**

- **Identity Law:**
  - \( P \land \text{True} \equiv P \)
  - \( P \lor \text{False} \equiv P \)

- **Domination Law (Annihilation Law):**
  - \( P \land \text{False} \equiv \text{False} \)
  - \( P \lor \text{True} \equiv \text{True} \)

- **Idempotent Law:**
  - \( P \land P \equiv P \)
  - \( P \lor P \equiv P \)

### 2. **Negation Laws**

- **Negation Law:**
  - $$\( P \land \neg P \equiv \text{False} \)$$
  - $$\( P \lor \neg P \equiv \text{True} \)  (Law of Excluded Middle)$$

- **Double Negation Law:**
  - $$\( \neg(\neg P) \equiv P \)$$

### 3. **Commutative Laws**

These laws state that the order of conjunction or disjunction does not matter:

$$\( P \land Q \equiv Q \land P \)$$ 
$$\( P \lor Q \equiv Q \lor P \)$$


### 4. **Associative Laws**

These laws state that the grouping of conjunction or disjunction does not affect the result:

- $$\( (P \land Q) \land R \equiv P \land (Q \land R) \)$$
- $$\( (P \lor Q) \lor R \equiv P \lor (Q \lor R) \)$$

### 5. **Distributive Laws**

These allow you to distribute conjunction over disjunction and vice versa:
$$\( P \land (Q \lor R) \equiv (P \land Q) \lor (P \land R) \)$$

$$\( P \lor (Q \land R) \equiv (P \lor Q) \land (P \lor R) \)
$$

### 6. **De Morgan’s Laws**

These are key rules for manipulating negations across conjunctions and disjunctions:

- $$\( \neg(P \land Q) \equiv \neg P \lor \neg Q \)$$
- $$\( \neg(P \lor Q) \equiv \neg P \land \neg Q \)$$

### 7. **Absorption Laws**

These simplify expressions where a variable is absorbed into a larger expression:

- $$\( P \land (P \lor Q) \equiv P \)$$
- $$\( P \lor (P \land Q) \equiv P \)$$

### 8. **Double Implication (Biconditional) Laws**

These express equivalences involving implications:

- $$\( P \iff Q \equiv (P \implies Q) \land (Q \implies P) \)$$

### 9. **Implication Laws**

These help you rewrite implications in terms of disjunction and negation:

- $$\\( P \implies Q \equiv \neg P \lor Q \)$$
- $$\( \neg(P \implies Q) \equiv P \land \neg Q \)$$

### 10. **Contrapositive Laws**

These describe the equivalence between an implication and its contrapositive:

- $$\( P \implies Q \equiv \neg Q \implies \neg P \)$$

### 11. **Complement Laws**

These deal with the combination of a variable and its negation:

- \( P \lor \neg P \equiv \text{True} \)
- \( P \land \neg P \equiv \text{False} \)

### 12. **Exclusive Or (XOR) Laws**

- \( P \oplus Q \equiv (P \lor Q) \land \neg(P \land Q) \)
- \( P \oplus P \equiv \text{False} \)  (XOR is false when both inputs are the same)
  
---

![[Pasted image 20241011193042.png]]
	