CREATE TABLE expenses (
    id UUID PRIMARY KEY,
    description TEXT NOT NULL,
    amount NUMERIC(19, 2) NOT NULL,
    category TEXT NOT NULL,
    expense_date DATE NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL
)