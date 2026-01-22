CREATE TABLE expenses (
    id UUID PRIMARY KEY,
    description TEXT NOT NULL,
    amount NUMERIC(19, 2) NOT NULL
)