CREATE TABLE [dbo].[TimeDimension] (
    [OrderDate]  DATETIME2 (3) NOT NULL,
    [OrderDay]   INT           NULL,
    [OrderMonth] INT           NULL,
    [OrderYear]  INT           NULL,
    CONSTRAINT [PK_TimeDimension] PRIMARY KEY CLUSTERED ([OrderDate] ASC)
);

