DECLARE
BEGIN
    FOR cust IN (
        SELECT c.CustomerID, l.LoanID, l.InterestRate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
        WHERE c.Age > 60
    )
    LOOP
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE LoanID = cust.LoanID;

        DBMS_OUTPUT.PUT_LINE(
            'Updated Loan ID: ' || cust.LoanID ||
            ' | New Interest Rate: ' || (cust.InterestRate - 1)
        );
    END LOOP;

    COMMIT;
END;
/