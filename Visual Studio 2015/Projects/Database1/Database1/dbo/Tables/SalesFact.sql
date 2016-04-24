CREATE TABLE [dbo].[SalesFact] (
    [ProductID] INT           NOT NULL,
    [OrderDate] DATETIME2 (3) NOT NULL,
    [Quantity]  INT           NULL,
    [Price]     MONEY         NULL,
    CONSTRAINT [PK_SalesFact] PRIMARY KEY CLUSTERED ([ProductID] ASC, [OrderDate] ASC),
    CONSTRAINT [FK_SalesFact_ProductDimension] FOREIGN KEY ([ProductID]) REFERENCES [dbo].[ProductDimension] ([ProductID]),
    CONSTRAINT [FK_SalesFact_TimeDimension] FOREIGN KEY ([OrderDate]) REFERENCES [dbo].[TimeDimension] ([OrderDate])
);

