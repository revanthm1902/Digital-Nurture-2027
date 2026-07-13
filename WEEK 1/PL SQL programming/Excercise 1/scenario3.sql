DECLARE
BEGIN
    FOR loan IN (
        SELECT c.Name, l.LoanID, l.DueDate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
        WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30
    )
    LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Loan ID ' || loan.LoanID ||
            ' for customer ' || loan.Name ||
            ' is due on ' || loan.DueDate
        );
    END LOOP;
END;
/